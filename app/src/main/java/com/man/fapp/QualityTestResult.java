package com.man.fapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import com.man.fapp.Fragment.Item_list;

public class QualityTestResult extends AppCompatActivity {
    private String category = null;
    private final String[] qualities = {"Normal", "Premium", "Classic"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quality_test_result);


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            category = extras.getString("category", "Wheat");
        }
        TextView tvName = findViewById(R.id.tvName);
        tvName.setText("Category: " + category);
        TextView tvRatio = findViewById(R.id.tvRatio);
        int randomNumber = getRandomNumber(40, 100);
        TextView district = findViewById(R.id.district);
        tvRatio.setText("Ratio: " + randomNumber + "/100");
        if(randomNumber<60){
            district.setText("Quality of the " + category + ": Normal");
        }
        else if (randomNumber>=60&&randomNumber<90){
            district.setText("Quality of the " + category + ": Premium");
        }
        else if (randomNumber>=90&&randomNumber<=100){
            district.setText("Quality of the " + category + ": Classic");
        }
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                finish ();

            }
        },5000);

    }

    private int getRandomNumber(int min, int max) {
        return (int) (Math.random() * (max - min) + min);

    }
}