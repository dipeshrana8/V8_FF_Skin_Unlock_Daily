package com.ffzone.skinbooster.protools.spalsh;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import com.ffzone.skinbooster.protools.R;
import com.ffzone.skinbooster.protools.databinding.ActivityLuckyLifafaBinding;
import com.ffzone.skinbooster.protools.myAds.WebNavigationUtils;


public class SurpriseBoxActivity extends BaseActivity {


    ActivityLuckyLifafaBinding binding;
    private boolean isClaimReady = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLuckyLifafaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnBack.setOnClickListener(v -> myBackActivity());

        binding.btnOpenNow.setOnClickListener(v -> {


            if (!isClaimReady) {
                new Handler().postDelayed(() -> {
                    binding.imgPreview.setImageResource(R.drawable.img_cong_latifa);
                    binding.txtOpen.setImageResource(R.drawable.img_open1);
                    binding.btnOpenNow.setImageResource(R.drawable.img_claim);

                    isClaimReady = true;
                }, 1000);
            } else {
                openClaim();
            }
        });

    }

    private void openClaim() {
        View dialogView = LayoutInflater.from(SurpriseBoxActivity.this).inflate(R.layout.dialog_spin_collect, null);
        AlertDialog dialog = new AlertDialog.Builder(SurpriseBoxActivity.this)
                .setView(dialogView)
                .create();

        if (dialog.getWindow() != null) {
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }

        TextView txtCollect = dialogView.findViewById(R.id.txtCollect);


        txtCollect.setText("You won: " + 50 + " diamonds");
        dialogView.findViewById(R.id.btnCollect).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("MyAppPrefs", MODE_PRIVATE);
                int currentTotal = sharedPreferences.getInt("reward_value", 0); // default is 0

                int my_new = Integer.parseInt("50");
                int updatedTotal = currentTotal + my_new;

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("reward_value", updatedTotal);
                editor.apply();

                binding.txtCountEarn.setText("Total : " + updatedTotal);


                WebNavigationUtils.WebInterstitial(SurpriseBoxActivity.this);
                dialog.dismiss();
            }
        });


        dialogView.findViewById(R.id.txtHome).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WebNavigationUtils.WebInterstitial(SurpriseBoxActivity.this);
                dialog.dismiss();
            }
        });
        dialogView.findViewById(R.id.txAD2X).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("MyAppPrefs", MODE_PRIVATE);
                int currentTotal = sharedPreferences.getInt("reward_value", 0); // default is 0

                int my_new = Integer.parseInt("100");
                int updatedTotal = currentTotal + my_new;

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("reward_value", updatedTotal);
                editor.apply();

                binding.txtCountEarn.setText("Total : " + updatedTotal);
                WebNavigationUtils.WebInterstitial(SurpriseBoxActivity.this);
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    @Override
    public void onBackPressed() {
        myBackActivity();
    }
}
