package com.example.alvin.alvin_midterm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;

import java.util.HashMap;

public class Screen3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen3);

        Intent intent = getIntent();
        final String image = intent.getStringExtra("image");


        ImageView mainImage = (ImageView) findViewById(R.id.imageViewX);
        mainImage.setImageResource(getResources().getIdentifier(image, "drawable", getPackageName()));

        RatingBar ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Intent intent = new Intent();
                intent.putExtra("starValue", (int) rating);
                setResult(RESULT_OK, intent);
                finish();
            }
        });


    }
}
