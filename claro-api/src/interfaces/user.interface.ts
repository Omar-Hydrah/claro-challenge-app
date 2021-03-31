import { Device } from "./device.interface";
export interface User{
  id: number;
  password: string;
  numberOfDevices: number;
  lastChanged: Date;
  devices: Device[];
}