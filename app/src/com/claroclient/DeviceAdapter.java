package com.claroclient;

import android.content.Context;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.graphics.drawable.Drawable;
import android.util.Log;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import com.claroclient.model.Device;

public class DeviceAdapter extends 
  RecyclerView.Adapter<DeviceAdapter.ViewHolder>
{
  private List<Device> devices;
  private Context context;

  public DeviceAdapter(Context context, List<Device> devices){
    this.devices = devices;
    this.context = context;
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
    View view = LayoutInflater.from(parent.getContext())
      .inflate(R.layout.row_device, parent, false);

    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(ViewHolder holder, int position){
    Device device = this.devices.get(position);
    Drawable drawable;

    if(device.getDeviceModel().equals("ios")){
      drawable = context.getResources().getDrawable(R.drawable.apple); 
    }else{
      drawable = context.getResources().getDrawable(R.drawable.android); 
    }

    holder.textName.setText(device.getName());
    holder.deviceImage.setImageDrawable(drawable);
  }

  @Override
  public int getItemCount(){
    return devices.size();
  }

  public class ViewHolder extends RecyclerView.ViewHolder{
    public TextView textName;
    public ImageView deviceImage;
    public ViewHolder(View item){
      super(item);
      textName = (TextView) item.findViewById(R.id.text_name);
      deviceImage = (ImageView) item.findViewById(R.id.image_device);
    }
  }
}