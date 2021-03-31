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

  changeDeviceName(userId: number, deviceId: string, newName: string){
    
  }
}
