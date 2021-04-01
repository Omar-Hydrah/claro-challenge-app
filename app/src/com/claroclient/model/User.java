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

}