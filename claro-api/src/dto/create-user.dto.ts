import {CreateDeviceDto} from "./create-device.dto";
export class CreateUserDto{
  id: number;
  password: string;
  numberOfDevices: number;
  lastChanged: Date; 
  devices: CreateDeviceDto[];
}