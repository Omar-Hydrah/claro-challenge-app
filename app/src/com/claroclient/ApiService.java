package com.claroclient;

import retrofit2.http.FormUrlEncoded;
import retrofit2.Call;
import retrofit2.http.Body;
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
import com.claroclient.request.RegisterDeviceRequest;
import com.claroclient.request.SwitchDeviceRequest;
import com.claroclient.request.RenameDeviceRequest;

public interface ApiService{

  @GET("/user/login/{id}")
  Single<User> login(@Path("id") String userId);

  @GET("/user/profile/{id}/device-list")
  Single<List<Device>> getDeviceList(@Path("id") String userId); 

  @GET("/device/{id}")
  Single<Device> getDevice(@Path("id") String device);

  // Contains two fields: deviceId, and newName
  @POST("/user/change-device-name")
  Single<String> changeDeviceName(@Body RenameDeviceRequest data);

  @POST("/user/remove-device/{id}")
  Single<String> removeDevice(@Path("id") String deviceId);

  @POST("/user/register-device")
  Single<String> registerDevice(@Body RegisterDeviceRequest data);

  @POST("/user/switch-device")
  Single<String> switchDevice(@Body SwitchDeviceRequest data);  
}