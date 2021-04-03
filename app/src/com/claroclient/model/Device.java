package com.claroclient.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Device{

  @Expose
  @SerializedName("id")
  private String id;

  @Expose
  @SerializedName("userId")
  private int userId;

  @Expose
  @SerializedName("name")
  private String name;

  @Expose
  @SerializedName("model")
  private String deviceModel;

  public Device(){

  }

  public Device(String id, int userId, String name, String model){
    this.id = id;
    this.userId = userId;
    this.name = name;
    this.deviceModel = model;
  }

  public void setId(String id){this.id = id;}
  public String getId(){return this.id;}

  public void setUserId(int userId){this.userId = userId;}
  public int getUserId(){return this.userId;}

  public void setName(String name){this.name = name;}
  public String getName(){return this.name;}

  public void setDeviceModel(String model){
    this.deviceModel = model;
  }
  public String getDeviceModel(){return this.deviceModel;}

  @Override
  public String toString(){
    return "{" +
      "id: " + id + ", " +
      "userId: " + String.valueOf(userId) + ", " +
      "name: "  + name + ", " + 
      "model: " + this.deviceModel +
      "}"; 
  }

}