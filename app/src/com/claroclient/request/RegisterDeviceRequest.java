package com.claroclient.request;

import com.claroclient.model.Device;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/*
A class representing an object to be send to /user/register-device/
*/
public class RegisterDeviceRequest{

  @Expose
  @SerializedName("userId")
  private int userId;

  @Expose
  @SerializedName("device")
  private Device device;

  public RegisterDeviceRequest(){}
  
  public RegisterDeviceRequest(int userId, Device device){
    this.userId = userId;
    this.device = device;
  }

  public int getUserId(){
    return this.userId;
  }
  public void setUserId(int userId){this.userId = userId;}

  public Device getDevice(){
    return this.device;
  }
  public void setDevice(Device device){this.device = device;}
}