package com.example.myapplication;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.myapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        ActivityMainBinding mainViewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        MainModel mainModel = new MainModel("liuxingxing", "123456");
        mainViewDataBinding.setModel(mainModel);

    }

}
