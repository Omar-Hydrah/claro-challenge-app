package com.claroclient;

import retrofit2.http.FormUrlEncoded;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.GET;
import retrofit2.http.FieldMap;
import retrofit2.http.Field;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;

import io.reactivex.Single;
import java.util.Map;
import java.util.List;

import com.claroclient.model.User;
import com.claroclient.model.Device;
import com.claroclient.request.RegisterDeviceRequest;
import com.claroclient.request.SwitchDeviceRequest;
import com.claroclient.request.RenameDeviceRequest;
import com.claroclient.response.ApiResponse;

public interface ApiService{

  @GET("/user/login/{id}")
  Single<User> login(@Path("id") String userId);

  @GET("/user/profile/{id}/device-list")
  Single<List<Device>> getDeviceList(@Path("id") String userId); 

  @GET("/device/{id}")
  Single<Device> getDevice(@Path("id") String device);

  // Contains two fields: deviceId, and newName
  @Headers({
    "Accept: application/json",
    "Content-Type: application/json"
  })
  @POST("/user/change-device-name")
  Single<ApiResponse> changeDeviceName(@Body RenameDeviceRequest data);

  @Headers({
    "Accept: application/json",
    "Content-Type: application/json"
  })
  @POST("/user/remove-device/{id}")
  Single<ApiResponse> removeDevice(@Path("id") String deviceId);

  @Headers({
    "Accept: application/json",
    "Content-Type: application/json"
  })
  @POST("/user/register-device")
  Single<ApiResponse> registerDevice(@Body RegisterDeviceRequest data);

  @Headers({
    "Accept: application/json",
    "Content-Type: application/json"
  })
  @POST("/user/switch-device")
  Single<ApiResponse> switchDevice(@Body SwitchDeviceRequest data);  
}