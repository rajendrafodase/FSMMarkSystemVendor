package com.example.fsmsystemvender.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.fsmsystemvender.LoginActivity;
import com.example.fsmsystemvender.MainActivity;
import com.example.fsmsystemvender.R;

public class OtpActivity extends AppCompatActivity {

    AppCompatButton varify_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        varify_btn=findViewById(R.id.varify_btn);
        varify_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(OtpActivity.this, MainActivity.class));
                finish();
            }
        });
    }
}