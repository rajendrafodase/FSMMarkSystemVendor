package com.example.fsmsystemvender;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fsmsystemvender.Constant.Constant;
import com.example.fsmsystemvender.Constant.SharedPreferenceManager;


public class SplashACtivity extends AppCompatActivity
{
    CountDownTimer timer;

    SharedPreferenceManager sharedPreferenceManager;

    String USER_ID="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.white, this.getTheme()));
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.white));
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        sharedPreferenceManager = new SharedPreferenceManager(SplashACtivity.this);

        sharedPreferenceManager.connectDB();
        USER_ID = sharedPreferenceManager.getString(Constant.USER_ID);
        sharedPreferenceManager.closeDB();

        Log.d("UserId",""+USER_ID);

        timer = new CountDownTimer(1200, 10) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish()
            {
                if(USER_ID.equals("") || USER_ID.equalsIgnoreCase("null"))
                {
                    startActivity(new Intent(SplashACtivity.this, LoginActivity.class));
                    finish();
                }
                else {
                    startActivity(new Intent(SplashACtivity.this, MainActivity.class));
                    finish();
                }

            }
        }.start();
    }
}