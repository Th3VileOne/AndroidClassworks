package com.example.alvin.randomguessingnumber;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void play(View view){
        EditText editText = (EditText) findViewById(R.id.editText);

        Intent intent = new Intent(this, GameActivity.class);
        intent.putExtra("username", editText.getText().toString());

        startActivity(intent);

    }

}
