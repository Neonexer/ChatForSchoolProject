package com.example.chat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;

public class SplashScreen extends AppCompatActivity {

    private FirebaseAuth auth;
    private boolean isLoggedIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        auth = FirebaseAuth.getInstance();
        isLoggedIn = auth.getCurrentUser() != null;

        CountDownTimer timer = new CountDownTimer(1000, 1000) {

            @Override
            public void onTick(long l) {
            }

            @Override
            public void onFinish() {
                if (isLoggedIn) {
                    startActivity(new Intent(SplashScreen.this, UserListActivity.class));
                } else {
                    startActivity(new Intent(SplashScreen.this, SignInActivity.class));
                }
            }
        };
        timer.start();
    }
}