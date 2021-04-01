import { Injectable } from '@nestjs/common';
import { User }       from "../interfaces/user.interface";
import { userList }   from "./users-mock"; 
import * as moment    from "moment";
import { Device, DeviceModel } from "../interfaces/device.interface";

@Injectable()
export class UserService {
  private readonly userList: User[] = [];

  constructor(){
    this.userList = userList;
  }

  registerDevice(userId: number, device: Device) : Result{
    let userIndex = -1;
    let user : User = userList.find((el, index)=>{
      if(el.id == userId){
        userIndex = index;
        return el.id;
      }
    });
    if(user == null){
      return Result.failure;
    }
    if(!this.isPassedTimeRestrain(user.lastChanged)){
      return Result.timeRestrain;
    }

    if(user.numberOfDevices > user.devices.length){
      userList[userIndex].devices.push(device);
      userList[userIndex].lastChanged = new Date();
    }else{
      return Result.maxDevice;
    }

    return Result.success;
  }

  switchDevice(userId: number, deviceId: string, newDevice: Device) : Result{
    let userIndex = -1;
    let deviceIndex = -1;
    let user : User = userList.find((el, index)=>{
      if(el.id == userId){
        userIndex = index;
        return el;
      }
    });

    if(user == null){
      return Result.failure;
    }

    let oldDevice = user.devices.find((d, index)=>{
      if(d.id == deviceId){
        deviceIndex = index;
        return d;
      }
    });

    if(oldDevice == null){
      // Failed to switch the target device
      return Result.failure;
    }

    if(!this.isPassedTimeRestrain(user.lastChanged)){
      return Result.timeRestrain;
    }else{
      user.devices[deviceIndex] = newDevice;
      user.lastChanged = new Date();
      userList[userIndex] = user;
    }

    return Result.success;
  }

  changeDeviceName(deviceId: string, newName: string) : Result{
    /*let userIndex   = -1;
    let deviceIndex = -1;
    for(var i = 0; i < userList.length; i++){
      let device : Device = userList[i].devices.find((d, index)=>{
        if(d.id == deviceId){
          userIndex = i;
          deviceIndex = index;
          return d;
        }
      });
    }*/
    let {userIndex, deviceIndex} = this.findDeviceOwnerIndex(deviceId);

    if(deviceIndex != null && userIndex != null){
      userList[userIndex].devices[deviceIndex].name = newName;
      return Result.success;
    }else{
      return Result.failure;
    }
  }

  removeDevice(deviceId : string) : Result{
    let {userIndex, deviceIndex} = this.findDeviceOwnerIndex(deviceId);

    if(deviceIndex != null && userIndex != null){
      userList[userIndex].devices.splice(deviceIndex, 1);
      return Result.success;
    }else{
      return Result.failure;
    }
  }

  getUser(userId: number) : User{
    let user : User = userList.find((u)=>{
      return u.id == userId;
    });
    return user;
  }

  getUserDevices(userId: number) : Device[]{
    let user : User = this.getUser(userId);
    if(!user){
      return null;
    }
    return user.devices;
  }

  private isPassedTimeRestrain(lastChanged : Date) : boolean{
    if(lastChanged == null){
      // In case of new users, lastChanged will always equal null
      return true;
    }

    let lastChange = moment(lastChanged);
    let now        = moment();
    let difference = now.diff(lastChange);
    difference = Math.floor(difference / 1000);

    let timeRestrain = 60 * 60 * 24 * 30;
    if(difference >= timeRestrain){
      return true;
    }else{
      return false;
    }
  }

  private findDeviceOwnerIndex(deviceId : string) : any{
    let userIndex   = -1;
    let deviceIndex = -1;
    for(var i = 0; i < userList.length; i++){
      let device : Device = userList[i].devices.find((d, index)=>{
        if(d.id == deviceId){
          userIndex = i;
          deviceIndex = index;
          return d;
        }
      });
    }

    return {userIndex, deviceIndex};
  }
}


export enum Result{
  success= "success",
  failure= "failure",
  // If the user tries to register more than he is allowed to
  maxDevice= "maxDevice",
  // If the user has already switched device in the past 30 days
  timeRestrain= "timeRestrain"
};