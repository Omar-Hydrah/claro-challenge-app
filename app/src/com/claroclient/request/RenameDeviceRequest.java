package com.claroclient.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RenameDeviceRequest{

  @Expose
  @SerializedName("deviceId")
  private String deviceId;

  @Expose
  @SerializedName("newName")
  private String newName;

  public RenameDeviceRequest(){}
  public RenameDeviceRequest(String deviceId, String newName){
    this.deviceId = deviceId;
    this.newName  = newName;
  }

  public void setDeviceId(String deviceId){this.deviceId = deviceId;}
  public String getDeviceId(){return this.deviceId;}

  public void setNewName(String newName){this.newName = newName;}
  public String getNewName(){return this.newName;}
}