package com.claroclient;

import retrofit2.http.FormUrlEncoded;
import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.FieldMap;
import retrofit2.http.Header;
import retrofit2.http.Path;

import io.reactivex.Single;
import java.util.Map;

public interface ApiService{
  @POST("/api/auth/login")
  Single<String> login(String userId);

}