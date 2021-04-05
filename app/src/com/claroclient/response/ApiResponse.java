package com.claroclient.response; 

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ApiResponse{
  
  @SerializedName("result")
  private String result;

  public ApiResponse(){}
  public ApiResponse(String result){
    this.result = result;
  }

  public String getResult(){
    return this.result;
  }

  @Override
  public String toString(){
    return "{result: " + this.result.toString() + "}";
  }

}