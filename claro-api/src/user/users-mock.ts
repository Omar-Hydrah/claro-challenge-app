import { User } from "../interfaces/user.interface";
import { Device, DeviceModel } from "../interfaces/device.interface";
import { v4 as uuidv4 } from "uuid";

export var userList : User[] = [
  {
    "id": 123,
    "password": "123",
    "numberOfDevices": 1,
    "lastChanged": null,
    "devices": []
  },
  {
    "id": 456,
    "password": "456",
    "numberOfDevices": 3,
    "lastChanged": new Date("2021-02-20"),
    "devices": [
      {
        "id": uuidv4(), 
        "userId": 456, 
        "name": "Joao", 
        "model": DeviceModel.ios
      },
      {
        "id": uuidv4(), 
        "userId": 456, 
        "name": "Mateus", 
        "model": DeviceModel.android
      },
      {
        "id": uuidv4(),
        "userId": 456, 
        "name": "Lucas",
        "model": DeviceModel.android
      }
    ]
  },
  {
    "id": 789,
    "password": "789",
    "numberOfDevices": 2,
    "lastChanged": new Date("2021-03-20"),
    "devices": [
      {
        "id": uuidv4(),
        "userId": 456, 
        "name": "David",
        "model": DeviceModel.android
      },
      {
        "id": uuidv4(),
        "userId": 456, 
        "name": "Jose",
        "model": DeviceModel.android
      }
    ]
  }
];