package com.claroclient.model;

import com.claroclient.model.Device;

public class User{
  private String id;
  private String password;
  private int numberOfDevices;
  private String lastChanged;
  private Device[] devices;

  public User(){

  }

  public User(String id, int numberOfDevices, String lastChanged, 
    Device[] devices)
  {
    this.id              = id;
    this.numberOfDevices = numberOfDevices;
    this.lastChanged     = lastChanged;
    this.devices         = devices;
  }

  public User(String id, String password, int numberOfDevices, 
    String lastChanged, Device[] devices)
  {
    this.id              = id;
    this.password        = password;
    this.numberOfDevices = numberOfDevices;
    this.lastChanged     = lastChanged;
    this.devices         = devices;
  }

  public void setId(String id){this.id = id;};
  public String getId(){return this.id;}

  public void setPassword(String password){this.password = password;}
  public String getPassword(){return this.password;}

  public void setNumberOfDevices(int number){this.numberOfDevices = number;}
  public int getNumberOfDevices(){return this.numberOfDevices;}

  public void setLastChanged(String lastChanged){
    this.lastChanged = lastChanged;
  }
  public String getLastChanged(){return this.lastChanged;}

  public void setDevices(Device[] devices){this.devices = devices;}
  public Device[] getDevices(){return this.devices;}

  @Override
  public String toString(){
    return "{id: " + this.id + "}";
  }
}