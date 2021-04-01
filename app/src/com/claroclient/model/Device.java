package com.claroclient.model;

public class Device{

  private String id;
  private int userId;
  private String name;
  private String deviceModel;

  public Device(){

  }

  public void setId(String id){this.id = id;}
  public String getId(){return this.id;}

  public void setUserId(int userId){this.userId = userId;}
  public int getUserId(){return this.userId;}

  public void setName(String name){this.name = name;}
  public String getName(){return this.name;}

  public void setDeviceModel(String deviceModel){
    this.deviceModel = deviceModel;
  }
  public String getDeviceModel(){return this.deviceModel;}

}