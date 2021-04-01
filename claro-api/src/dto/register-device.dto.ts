import { CreateDeviceDto } from "./create-device.dto";

export class RegisterDeviceDto{
  userId : number;
  device : CreateDeviceDto;
}