package com.example.alvin.randomguessingnumber;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity {
    TextView textView = null;

    private int answer = (int)((Math.random() * 100) + 1);

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        textView = (TextView) findViewById(R.id.helloText);
        Intent intent = getIntent();
        String name = intent.getStringExtra("username");
        textView.setText("Hello, " + name);

        Toast.makeText(getApplicationContext(), "Click CLEAR to start the game", Toast.LENGTH_SHORT).show();
    }
    public void clear(View view){
        textView.setText("");
    }
    public void pressNumbers(View view){
        Button selectedButton = (Button) view;
        textView.setText(textView.getText() + selectedButton.getText().toString());
    }
    public void guess(View view) {
        int usernumber = Integer.parseInt(textView.getText().toString());
        String str = "";
        if(usernumber < answer){
            str = "Too Low!";
        }else if(usernumber > answer){
            str = "Too High!";
        }else {
            str = "Correct!";
        }
        Toast.makeText(getApplicationContext(),str, Toast.LENGTH_SHORT).show();
    }

}
