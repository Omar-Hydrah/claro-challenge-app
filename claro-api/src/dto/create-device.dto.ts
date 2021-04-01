export class CreateDeviceDto{
  id: string;
  userId: number;
  name: string;
  model: DeviceModel;
}

export enum DeviceModel{
  ios     = "ios",
  android = "android"
}