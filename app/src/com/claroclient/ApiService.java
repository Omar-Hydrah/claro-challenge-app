package com.claroclient;

import retrofit2.http.FormUrlEncoded;
import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.GET;
import retrofit2.http.FieldMap;
import retrofit2.http.Field;
import retrofit2.http.Header;
import retrofit2.http.Path;

import io.reactivex.Single;
import java.util.Map;
import java.util.List;

import com.claroclient.model.User;
import com.claroclient.model.Device;

public interface ApiService{

  @GET("/user/profile/{id}")
  Single<User> login(@Path("id") String userId);

  @GET("/user/profile/{id}/device-list")
  Single<List<Device>> getDeviceList(@Path("id") String userId); 
}