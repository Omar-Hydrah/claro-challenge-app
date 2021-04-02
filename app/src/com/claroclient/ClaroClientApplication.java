package com.claroclient;

import android.app.Application;
import android.content.Context;

public class ClaroClientApplication extends Application{

  private static Context context;

  @Override
  public void onCreate(){
    super.onCreate();
    ClaroClientApplication.context = getApplicationContext();
  }

  public static Context getContext(){
    return ClaroClientApplication.context;
  }
}