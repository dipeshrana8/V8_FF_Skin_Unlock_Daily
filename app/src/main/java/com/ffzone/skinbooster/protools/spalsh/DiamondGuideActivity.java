package com.ffzone.skinbooster.protools.spalsh;

import android.os.Bundle;

import com.ffzone.skinbooster.protools.databinding.ActivityTipsBinding;

public class DiamondGuideActivity extends BaseActivity {
    ActivityTipsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        toolbarHeaderText = "Diamond Guide";


        binding = ActivityTipsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setupToolbar(
                binding.toolbarLayout.headerTitle,
                binding.toolbarLayout.btnBack,
                binding.toolbarLayout.btnSettings
        );
        binding.toolbarLayout.btnBack.setOnClickListener(v -> myBackActivity());


    }

    @Override
    public void onBackPressed() {
        myBackActivity();
    }
}