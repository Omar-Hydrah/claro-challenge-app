package com.claroclient;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.android.schedulers.AndroidSchedulers;

import com.claroclient.MainActivity;
import com.claroclient.AppRepository;
import com.claroclient.model.User;

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
      .subscribe(this::handleSuccess, this::handleError);
  }
  public void displayMessage(String message){
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
  }

  private void handleSuccess(User user){
    if(user != null){
      try{
        // The user is not a null object
        user.toString();
        Intent homeIntent = new Intent(this, MainActivity.class);
        startActivity(homeIntent);
      }catch(Exception e){
        displayMessage("User id not found");
      }
    }
  }

  private void handleError(Throwable t){
    displayMessage("User id not found");
    Log.i("claroclient", t.toString());
  }
}
