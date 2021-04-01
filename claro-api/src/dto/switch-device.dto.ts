import { CreateDeviceDto } from "./create-device.dto";

export class SwitchDeviceDto{
  userId : number;
  deviceId : string; // uuid;
  newDevice : CreateDeviceDto;
}