package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import com.example.myapplication.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {
    private HomeViewModel homeViewModel;
    private ActivityHomeBinding homeBinding;

    final static String kATeamScore = "aTeamScore";
    final static String kBTeamScore = "bTeamScore";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_home);
        homeBinding = DataBindingUtil.setContentView(this,R.layout.activity_home);
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        if (savedInstanceState != null) {
            homeViewModel.getaTeamScore().setValue(savedInstanceState.getInt(kATeamScore));
            homeViewModel.getbTeamScore().setValue(savedInstanceState.getInt(kBTeamScore));
        }
        homeBinding.setData(homeViewModel);
        homeBinding.setLifecycleOwner(this);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(kATeamScore,homeViewModel.getaTeamScore().getValue());
        outState.putInt(kBTeamScore,homeViewModel.getbTeamScore().getValue());
    }
}
