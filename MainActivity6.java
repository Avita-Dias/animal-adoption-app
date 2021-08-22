package com.example.madproj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        getSupportFragmentManager().beginTransaction().replace(R.id.wrapper2,new recfragment2()).commit();
    }
}