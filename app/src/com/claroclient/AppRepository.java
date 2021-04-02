package com.claroclient;

import android.content.Context;
import android.util.Log;

import io.reactivex.Single;
import io.reactivex.Observable;

import java.util.List;
import java.util.Map;

import com.claroclient.ApiRequest;
import com.claroclient.model.User;

public class AppRepository{
  private static AppRepository instance;
  private ApiRequest request;

  public static AppRepository getInstance(){
    if(instance == null){
      instance = new AppRepository();      
    }
    return instance;
  }

  private AppRepository(){
    request = new ApiRequest();
  }

  public Single<User> login(String userId){
    return request.login(userId);
  }
}