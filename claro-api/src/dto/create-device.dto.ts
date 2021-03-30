export class CreateDeviceDto{
  id: number;
  userId: number;
  name: string;
  model: DeviceModel; 
}

enum DeviceModel{
  ios     = "ios",
  android = "android"
}