package com.claroclient.model;

import com.claroclient.model.Device;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class User{

  @Expose
  @SerializedName("id")
  private int id;

  private String password;

  @Expose
  @SerializedName("numberOfDevices")
  private int numberOfDevices;

  @Expose
  @SerializedName("lastChanged")
  private String lastChanged;

  @Expose
  @SerializedName("devices")
  private Device[] devices;

  public User(){

  }

  public User(int id, int numberOfDevices, String lastChanged, 
    Device[] devices)
  {
    this.id              = id;
    this.numberOfDevices = numberOfDevices;
    this.lastChanged     = lastChanged;
    this.devices         = devices;
  }

  public User(int id, String password, int numberOfDevices, 
    String lastChanged, Device[] devices)
  {
    this.id              = id;
    this.password        = password;
    this.numberOfDevices = numberOfDevices;
    this.lastChanged     = lastChanged;
    this.devices         = devices;
  }

  public void setId(int id){this.id = id;};
  public int getId(){return this.id;}

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