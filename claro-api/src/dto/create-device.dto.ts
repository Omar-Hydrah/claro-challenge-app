export class CreateDeviceDto{
  id: number;
  userId: number;
  name: string;
  model: DeviceModel;
}

export enum DeviceModel{
  ios     = "ios",
  android = "android"
}