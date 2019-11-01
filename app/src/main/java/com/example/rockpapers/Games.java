package com.example.rockpapers;

import androidx.appcompat.app.AppCompatActivity;

public class Games extends AppCompatActivity {
  private String secret;

  public String getSecret(){
    return this.secret;
  }
  public void setSecret(String sec){
    this.secret = sec;
  }
}
