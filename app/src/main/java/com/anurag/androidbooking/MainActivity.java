package com.anurag.androidbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void registerPressed(View view) {
        Intent registerIntent = new Intent(MainActivity.this, RegisterActivity.class);
        startActivity(registerIntent);
    }

    public void loginPressed(View view) {
        Intent loginIntent = new Intent(MainActivity.this, UserLoginActivity.class);
        startActivity(loginIntent);
    }

    public void adminLoginPressed(View view) {
        Intent adminIntent = new Intent(MainActivity.this, AdminLoginActivity.class);
        startActivity(adminIntent);
    }
}
