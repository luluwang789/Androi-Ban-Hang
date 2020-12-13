package com.example.trana.cuahangthietbionline.View;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.trana.cuahangthietbionline.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        // Start main activity
        startActivity(new Intent(SplashActivity.this, DangNhapActivity.class));
        // close splash activity
        finish();
    }
}
