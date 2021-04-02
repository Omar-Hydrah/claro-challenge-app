package com.claroclient;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;

import com.claroclient.AppRepository;
import com.claroclient.model.User;

import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{

  private AppRepository repo;
  private TextView userIdText;

  /** Called when the activity is first created. */
  @Override
  public void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    repo = AppRepository.getInstance();

    String userId = repo.getUserId();

    userIdText = (TextView) findViewById(R.id.userId);
    userIdText.setText(userId);
  }
}
