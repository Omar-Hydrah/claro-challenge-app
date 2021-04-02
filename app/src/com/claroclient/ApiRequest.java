package com.claroclient;

import android.widget.Toast;
import android.util.Log;

import okhttp3.ResponseBody;
import okhttp3.OkHttpClient;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import io.reactivex.Observable;
import io.reactivex.Single;

import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

import com.claroclient.util.Constants;
import com.claroclient.ApiService;
import com.claroclient.model.User;
import com.claroclient.model.Device;

public class ApiRequest {
  private Retrofit retrofit;
  private String BASE_URL = Constants.BASE_URL;  
  private ApiService service;

  public ApiRequest(){
    OkHttpClient client = buildClient();

    retrofit = new Retrofit.Builder()
      .baseUrl(BASE_URL)
      .client(client)
      .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
      .addConverterFactory(GsonConverterFactory.create())
      .build();

    service = retrofit.create(ApiService.class);
  }

  public Single<User> login(String userId){
    return service.login(userId);
  }

  public Single<List<Device>> getDeviceList(String userId){
    return service.getDeviceList(userId);
  }

  public OkHttpClient buildClient(){
    OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder(); 
    clientBuilder.addInterceptor(new Interceptor(){
      @Override
      public okhttp3.Response intercept(Interceptor.Chain chain) 
        throws IOException
      {
        Request originalRequest = chain.request();
        Request.Builder requestBuilder = originalRequest.newBuilder()
          .header("User-Agent", "Claro Client");
        Request request = requestBuilder.build();

        return chain.proceed(request);
      }
    });

    HttpLoggingInterceptor loggingInterceptor 
      = new HttpLoggingInterceptor();
    loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

    clientBuilder.addInterceptor(loggingInterceptor);

    OkHttpClient client = clientBuilder.build();
    return client;
  }
}