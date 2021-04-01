import { Controller, Get, Post, Body, Param, Req } from '@nestjs/common';
import { UserService, Result } from "./user.service";
import { Device }              from "../interfaces/device.interface";
import { ChangeDeviceNameDto } from "../dto/change-device-name.dto";
import { CreateDeviceDto } from "../dto/create-device.dto";
import { RegisterDeviceDto } from "../dto/register-device.dto";
import { SwitchDeviceDto } from "../dto/switch-device.dto";

@Controller('user')
export class UserController {
  constructor(private userService : UserService){}
  
  @Post("remove-device/:id")
  removeDevice(@Param() params) : Result{
    return this.userService.removeDevice(params.id);
  }

  @Post("register-device")
  registerDevice(@Body() dto : RegisterDeviceDto) : Result{
    return this.userService.registerDevice(dto.userId, dto.device as Device);
  }

  @Post("switch-device")
  switchDevice(@Body() dto : SwitchDeviceDto) : Result{
    return this.userService.switchDevice(dto.userId, dto.deviceId, 
      dto.newDevice as Device);
  }

  @Post("change-device-name")
  changeDeviceName(@Body() dto : ChangeDeviceNameDto) : Result{
    return this.userService.changeDeviceName(dto.deviceId, dto.newName);
  }
}
