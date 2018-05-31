package com.example.viacheslav.popstarvote;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String selectedName = "";
    private static final int CODE = 2017;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CODE && resultCode == RESULT_OK) {
            String str = "You have rated " + selectedName + " for " + data.getIntExtra("starValue", 0) + " star(s)";
            Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
        }
    }

    public void taylorClick(View view) {
        selectedName = "Taylor";
        clickImage(selectedName, "taylor_small");
    }

    public void taeyeonClick(View view) {
        selectedName = "Taeyeon";
        clickImage(selectedName, "taeyeon_small");
    }

    private void clickImage(String name, String id) {
        Intent intent = new Intent(this, RatingActivity.class);
        intent.putExtra("image_name", id);
        startActivityForResult(intent, CODE);
    }
}
