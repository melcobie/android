package com.example.test.view.fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import com.example.test.R;
import com.example.test.view.HomepageActivity;
import com.example.test.view.MainActivity;

public class FirstActivity extends AppCompatActivity {
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences sharedPreferences = getSharedPreferences("userIdentity",MODE_PRIVATE);
                String Token = sharedPreferences.getString("token",null);
                Intent intent;
                System.out.println(Token);
                if(Token != null){
                    intent = new Intent(FirstActivity.this, HomepageActivity.class);
                }
                else {
                    intent = new Intent(FirstActivity.this, MainActivity.class);
                }
                startActivity(intent);
            }
        }, 5000);
    }
}