package com.example.viacheslav.popstarvote;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.RatingBar;

public class RatingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);

        Intent intent = getIntent();
        String imageName = intent.getStringExtra("image_name");

        ImageView mainImage = (ImageView) findViewById(R.id.imageMain);
        mainImage.setImageResource(getResources().getIdentifier(imageName, "drawable", getPackageName()));

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
