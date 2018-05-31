package com.example.alvin.myapplication;

        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;
        import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private String name = "";
    private int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button sendBTN = (Button) findViewById(R.id.send);
        sendBTN.setOnClickListener(this);
        Button pressBTN = (Button) findViewById(R.id.pressme);
        pressBTN.setOnClickListener(this);
    }
    public void onClick(View v) {
        TextView textView = (TextView) findViewById(R.id.textview);
        EditText edittext = (EditText) findViewById(R.id.edit_message);
        String text = "";
        if(v.getId() == R.id.send){
            name = edittext.getText().toString();
        }else if(v.getId() == R.id.pressme){
            count++;
            Button btn = (Button) findViewById(R.id.pressme);
            btn.setText("Got Pressed: " + count);
            Toast.makeText(getApplicationContext(), "Button got pressed", Toast.LENGTH_SHORT).show();
        }
        text = "Hi, " + name + "\nButton got pressed " + count + " times";
        textView.setText(text);
    }
}