package com.example.rvradiobuttonfm.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.rvradiobuttonfm.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentA fragmentA = new FragmentA();


        if(savedInstanceState == null){//แก้เรื่อง ซ้อนของ Fragfment
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.contentContainer_main,fragmentA)
                    //.addToBackStack("")
                    .commit();
        }
    }
}
