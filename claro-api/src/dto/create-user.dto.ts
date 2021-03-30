import {CreateDeviceDto} from "./create-device.dto";
export class CreateUserDto{
  id: number;
  password: string;
  device: CreateDeviceDto[];
}