package com.claroclient;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import android.widget.TextView;
import android.widget.ImageView;
import android.graphics.drawable.Drawable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.android.schedulers.AndroidSchedulers;

import com.claroclient.AppRepository;
import com.claroclient.model.Device;


public class DeviceDetailsActivity extends AppCompatActivity{
  
  private AppRepository repo;
  private TextView  deviceName;
  private ImageView deviceImage;

  @Override
  public void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_device_details);

    deviceName  = (TextView) findViewById(R.id.text_name);
    deviceImage = (ImageView) findViewById(R.id.image_device_icon);

    Gson gson     = new Gson();
    Device device = gson.fromJson(getIntent().getStringExtra("deviceJson"),
      Device.class); 

    deviceName.setText(device.getName());
    /* Change the device icon from android (default) to ios */
    if(device.getDeviceModel().equals("ios")){
      Drawable drawable = this.getResources()
        .getDrawable(R.drawable.apple_36);

      deviceImage.setImageDrawable(drawable);
    }
  } 

  public void renameDevice(View view){

  }

  public void switchDevice(View view){

  }

  public void removeDevice(View view){

  }
}