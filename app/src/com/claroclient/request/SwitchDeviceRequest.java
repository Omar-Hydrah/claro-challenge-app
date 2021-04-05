package com.claroclient.request;

import com.claroclient.model.Device;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/*
A class representing an object to be send to /user/switch-device
*/
public class SwitchDeviceRequest{
  @Expose
  @SerializedName("userId")
  private int userId;

  @Expose
  @SerializedName("deviceId")
  private String deviceId;

  @Expose
  @SerializedName("newDevice")
  private Device newDevice;

  public SwitchDeviceRequest(){}

  public SwitchDeviceRequest(int userId, String deviceId, Device newDevice){
    this.userId    = userId;
    this.deviceId  = deviceId;
    this.newDevice = newDevice;
  }
  public void setUserId(int userId){this.userId = userId;}
  public int getUserId(){return this.userId;}

  public void setDeviceId(String deviceId){this.deviceId = deviceId;}
  public String getDeviceId(){return this.deviceId;}

  public void setNewDevice(Device newDevice){this.newDevice = newDevice;}
  public Device getNewDevice(){return this.newDevice;}
}