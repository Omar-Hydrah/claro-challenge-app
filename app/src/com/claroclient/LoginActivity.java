package com.claroclient;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.android.schedulers.AndroidSchedulers;

import com.claroclient.MainActivity;
import com.claroclient.AppRepository;

public class LoginActivity extends AppCompatActivity
{

  private AppRepository repo;
  private EditText inputUserId;

  /** Called when the activity is first created. */
  @Override
  public void onCreate(Bundle savedInstanceState)
  {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_login);

      inputUserId = (EditText) findViewById(R.id.userid);
      repo = AppRepository.getInstance();
  }

  public void login(View view){
    final String userId  = inputUserId.getText().toString().trim();

    repo.login(userId)
      .subscribeOn(Schedulers.io())
      .observeOn(AndroidSchedulers.mainThread())
      .subscribe(response -> {
        if(response == "success"){
          Intent homeIntent = new Intent(this, MainActivity.class);
          startActivity(homeIntent);
        }else if(response == "failure"){
          displayMessage("User id not found");
        }else{
          displayMessage("Uknown response received");
        }
      });
  }
  public void displayMessage(String message){
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
  }
}
