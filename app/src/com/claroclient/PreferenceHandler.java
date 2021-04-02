package com.claroclient;

import android.content.SharedPreferences;
import android.content.Context;
import android.preference.PreferenceManager;

import java.util.Map;

public class PreferenceHandler {
  private SharedPreferences sharedPreferences;
  private SharedPreferences.Editor editor;
  private Context context;

  public PreferenceHandler(){
    context = ClaroClientApplication.getContext();
    sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    editor  = sharedPreferences.edit(); 
  }

  public void putUserId(String userId){
    editor.putString("userId", userId);
    editor.commit();
  }

  public String getUserId(){
    return sharedPreferences.getString("userId", null);
  }
}