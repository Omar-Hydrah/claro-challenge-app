import { Test, TestingModule } from '@nestjs/testing';
import { UserService, Result } from './user.service';
import { Device, DeviceModel } from "../interfaces/device.interface";
import { User }                from "../interfaces/user.interface";
import { v4 as uuidv4 } from "uuid";
import { userList as userMock }    from "./users-mock";

describe('UserService', () => {
  let service: UserService;
  let userList: User[];

  beforeEach(async () => {
    const module: TestingModule = await Test.createTestingModule({
      providers: [UserService],
    }).compile();

    service  = module.get<UserService>(UserService);
    userList = userMock; 
  });

  it('should be defined', () => {
    expect(service).toBeDefined();
  });

  describe("Register a new device", ()=>{
    it("should fail upon exceeding numberOfDevices", ()=>{
      let userId = userList[1].id;
      let result = service.registerDevice(userId, 
        {id: uuidv4(), userId: userId, name: "Adao", model:DeviceModel.ios});

      expect(result).toEqual(Result.maxDevice);
    });

    it("should fail if lastChange is less than 30 days", ()=>{
      let userId = userList[2].id;
      let result = service.registerDevice(userId, 
        {id: uuidv4(), userId:userId, name: "Moses", model: DeviceModel.ios});

      expect(result).toEqual(Result.timeRestrain);
    });

    it("should succeed if numberOfDevices is bigger than devices.length", ()=>{
      let userId = userList[0].id;
      let result = service.registerDevice(userId, 
          {id: uuidv4(), userId:userId, name: "Adao", model:DeviceModel.ios});

      expect(result).toEqual(Result.success);
      
    });

  });

  it("should change the name of the device using the id", ()=>{
    // The service would search the device id in the users list
    // through the devices property
    let deviceId = userList[1].devices[0].id;
    let newName  = "Abrao";
    let result = service.changeDeviceName(deviceId, newName);
    expect(result).toEqual(Result.success);
    expect(userList[1].devices[0].name).toEqual(newName);
  });

  describe("Switching a device", ()=>{
    it("should fail because of the time restrain", ()=>{
      let deviceId = userList[2].devices[0].id;
      let userId   = userList[2].id;
      let device : Device = {
        id: uuidv4(), 
        userId: userId,
        name: "Salomao",
        model: DeviceModel.ios 
      };

      let result = service.switchDevice(userId, deviceId, device);
      expect(result).toEqual(Result.timeRestrain);
    });
    it("should succeed", ()=>{
      let deviceId = userList[1].devices[0].id;
      let userId   = userList[1].id;
      let device : Device = {
        id: uuidv4(), 
        userId: userId,
        name: "Salomao",
        model: DeviceModel.ios 
      };

      let result = service.switchDevice(userId, deviceId, device);
      expect(result).toEqual(Result.success);
    });
  });

  describe("Removing a device", ()=>{
    it("should remove a device", ()=>{
      let deviceCount : number = userList[1].devices.length;

      let device : Device = userList[1].devices[0];
      let result = service.removeDevice(device.id);

      expect(result).toEqual(Result.success);
      expect(userList[1].devices.length).toEqual(deviceCount - 1);
    });
  });
});
