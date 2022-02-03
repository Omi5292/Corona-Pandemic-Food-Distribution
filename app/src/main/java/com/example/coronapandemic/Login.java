package com.example.coronapandemic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);
    }
    public void log1(View view) {
        Intent homeIntent = new Intent(Login.this, Register.class);
        startActivity(homeIntent);
    }
    public void log2(View view) {
        Intent homeIntent = new Intent(Login.this, Register.class);
        startActivity(homeIntent);
    }
    public void log3(View view) {
        Intent homeIntent = new Intent(Login.this, Register.class);
        startActivity(homeIntent);
    }
    public void res(View view) {
        Intent homeIntent = new Intent(Login.this, com.example.coronapandemic.View.class);
        startActivity(homeIntent);
    }
}