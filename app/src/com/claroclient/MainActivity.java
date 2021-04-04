package com.claroclient;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.gson.Gson;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.android.schedulers.AndroidSchedulers;

import com.claroclient.AppRepository;
import com.claroclient.DeviceAdapter;
import com.claroclient.model.User;
import com.claroclient.model.Device;


public class MainActivity extends AppCompatActivity 
  implements DeviceClickListener
{

  private AppRepository repo;
  private TextView userIdText;
  private DeviceAdapter adapter;
  private RecyclerView recyclerView;

  /** Called when the activity is first created. */
  @Override
  public void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    repo = AppRepository.getInstance();

    String userId = repo.getUserId();

    recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
    userIdText   = (TextView) findViewById(R.id.userId);

    recyclerView.setLayoutManager(new LinearLayoutManager(this));
    userIdText.setText(userId);

    repo.getDeviceList(userId)
      .subscribeOn(Schedulers.io())
      .observeOn(AndroidSchedulers.mainThread())
      .subscribe(this::handleSuccess, this::handleError);
  }

  private void handleSuccess(List<Device> devices){
    adapter = new DeviceAdapter(this, devices);
    recyclerView.setAdapter(adapter);
  }

  private void handleError(Throwable t){
    Toast.makeText(this, "Failed to find devices", Toast.LENGTH_SHORT)
      .show();
  }

  @Override
  public void handleDeviceClick(Device device){
    Gson gson         = new Gson();
    String deviceJson = gson.toJson(device);

    Intent detailsIntent = new Intent(this, DeviceDetailsActivity.class);
    detailsIntent.putExtra("deviceJson", deviceJson);
    startActivity(detailsIntent); 
  }
}
