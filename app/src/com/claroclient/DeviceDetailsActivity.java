package com.claroclient;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.Button;
import android.graphics.drawable.Drawable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.android.schedulers.AndroidSchedulers;

import com.claroclient.AppRepository;
import com.claroclient.model.Device;
import com.claroclient.response.ApiResponse;
import com.claroclient.response.ApiResult;


public class DeviceDetailsActivity extends AppCompatActivity{
  
  private AppRepository repo;
  // device name
  private TextView  textName;
  private ImageView deviceImage;
  private Button buttonRename;
  // Field to rename a device
  private EditText inputName; 
  // To manipulate text on button_rename
  private boolean isRenaming; 
  private Device device;

  @Override
  public void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_device_details);

    repo = AppRepository.getInstance();

    textName    = (TextView) findViewById(R.id.text_name);
    deviceImage = (ImageView) findViewById(R.id.image_device_icon);
    inputName   = (EditText) findViewById(R.id.input_name);
    buttonRename = (Button) findViewById(R.id.button_rename);

    Gson gson = new Gson();
    device    = gson.fromJson(getIntent().getStringExtra("deviceJson"),
      Device.class); 

    textName.setText(device.getName());
    /* Change the device icon from android (default) to ios */
    if(device.getDeviceModel().equals("ios")){
      Drawable drawable = this.getResources()
        .getDrawable(R.drawable.apple_36);

      deviceImage.setImageDrawable(drawable);
    }
  } 

  public void renameDevice(View view){
    if(isRenaming){
      // Submit a request to the server to change the device name
      String newName = inputName.getText().toString().trim();
      repo.changeDeviceName(this.device.getId(), newName)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(this::handleRenamingResponse, 
          this::handleRenamingFailure);
    }
    isRenaming = !isRenaming;
    toggleVisibility();

  }

  public void switchDevice(View view){

  }

  public void removeDevice(View view){
    repo.removeDevice(this.device.getId())
      .subscribeOn(Schedulers.io())
      .observeOn(AndroidSchedulers.mainThread())
      .subscribe(this::handleRemoveResponse, this::handleRemoveFailure);
    // finish();
  }

  private void toggleVisibility(){
    if(isRenaming){
      textName.setVisibility(View.INVISIBLE);
      inputName.setVisibility(View.VISIBLE);
      buttonRename.setText(R.string.save);
      inputName.setText(this.device.getName());
    }else{
      textName.setVisibility(View.VISIBLE);
      inputName.setVisibility(View.INVISIBLE);
      buttonRename.setText(R.string.rename);
    }
  }

  private void handleRenamingResponse(ApiResponse response){
    if(response.getResult().equals(ApiResult.SUCCESS.toString())){
      Toast.makeText(this, "Name changed successfully" , 
        Toast.LENGTH_SHORT).show();
    }else{
      Toast.makeText(this, "Failed to change name" , 
        Toast.LENGTH_SHORT).show();
    }
  }

  private void handleRenamingFailure(Throwable t){
    Toast.makeText(this, "Failed to change name", Toast.LENGTH_SHORT).show();
  }

  private void handleRemoveResponse(ApiResponse response){
    if(response.getResult().equals(ApiResult.SUCCESS.toString())){
      finish();
      Toast.makeText(this, "Device removed successfully" , 
        Toast.LENGTH_SHORT).show();
    }else{
      Toast.makeText(this, "Failed to remove device", 
        Toast.LENGTH_SHORT).show();
    }
  }

  private void handleRemoveFailure(Throwable t){
    Log.i("claroclient", t.toString());
    Toast.makeText(this, "Failed to remove device", Toast.LENGTH_SHORT).show();
  }
}