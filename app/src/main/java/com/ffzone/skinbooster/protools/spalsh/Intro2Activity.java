package com.ffzone.skinbooster.protools.spalsh;

import android.content.Intent;
import android.os.Bundle;

import com.ffzone.skinbooster.protools.databinding.ActivityEveryDayBinding;

public class Intro2Activity extends BaseActivity {

    ActivityEveryDayBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEveryDayBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.btnNext.setOnClickListener(v -> {
            Intent intent = new Intent(Intro2Activity.this, CountryActivity.class);
            startActivity(intent);
        });

    }

    @Override
    public void onBackPressed() {
        myBackActivity();
    }
}