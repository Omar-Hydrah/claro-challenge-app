import { Injectable } from '@nestjs/common';
import { User }       from "../interfaces/user.interface";
import { userList }   from "./users-mock"; 
import { Device, DeviceModel } from "../interfaces/device.interface";

@Injectable()
export class UserService {
  private readonly userList: User[] = [];

  constructor(){
    this.userList = userList;
  }

  registerDevice(userId: number, device: Device){

  }

  switchDevice(userId: number, deviceId: string, newDevice: Device){

  }

  changeDeviceName(deviceId: string, newName: string){

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