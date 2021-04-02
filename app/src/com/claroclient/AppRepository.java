package com.claroclient;

import android.content.Context;
import android.util.Log;

import io.reactivex.Single;
import io.reactivex.Observable;

import java.util.List;
import java.util.Map;

import com.claroclient.ApiRequest;
import com.claroclient.PreferenceHandler;
import com.claroclient.model.User;
import com.claroclient.model.Device;

public class AppRepository{
  private static AppRepository instance;
  private ApiRequest request;
  private PreferenceHandler prefHandler;


  public static AppRepository getInstance(){
    if(instance == null){
      instance = new AppRepository();      
    }
    return instance;
  }

  private AppRepository(){
    request     = new ApiRequest();
    prefHandler = new PreferenceHandler(); 
  }

  public Single<User> login(String userId){
    return request.login(userId);
  }

  public Single<List<Device>> getDeviceList(String userId){
    return request.getDeviceList(userId);
  }

  public void putUserId(String userId){
    prefHandler.putUserId(userId);
  }

  public String getUserId(){
    return prefHandler.getUserId();
  }
}