package com.example.alvin.alvin_midterm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.HashMap;



public class Screen2 extends AppCompatActivity {

    private String selectedName = "";
    private static final int CODE = 2017;

    public String[] uniList = {"Thammasat University", "Chulalongkorn University", "Kasetsart University", "Assumption University","Stamford International University"};
    public Integer thamScore = 0;
    public Integer chulaScore = 0;
    public Integer kasetScore = 0;
    public Integer abacScore = 0;
    public Integer stamford = 0;


    HashMap<String,Integer> uniData = new HashMap <String,Integer>();
     public HashMap<String, Integer> uniData() {
        uniData.put("thammasat", 0);
        uniData.put("chula", 0);
        uniData.put("kaset", 0);
        uniData.put("abac",0);
        uniData.put("stamford", 0);
        return uniData;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);
        uniData();

        TextView textViewScreen2 = (TextView) findViewById(R.id.textViewScreen2);
        textViewScreen2.setText("Thammasat University: " + uniData.get("thammasat"));
        TextView textViewScreen3 = (TextView) findViewById(R.id.textView3);
        textViewScreen3.setText("Chulalongkorn University: " + uniData.get("chula"));
        TextView textViewScreen4 = (TextView) findViewById(R.id.textView4);
        textViewScreen4.setText("Kasetsart University: " + uniData.get("kaset"));
        TextView textViewScreen5 = (TextView) findViewById(R.id.textView5);
        textViewScreen5.setText("Assumption University: " + uniData.get("abac"));
        TextView textViewScreen6 = (TextView) findViewById(R.id.textView6);
        textViewScreen6.setText("Stamford University: " + uniData.get("stamford"));
        ;


        ListView listView = (ListView) findViewById(R.id.ListView1);
        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, uniList);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0: {
                        Intent i = new Intent(getApplicationContext(), Screen3.class);
                        selectedName = "thammasat";
                        i.putExtra("image", selectedName);
                        startActivityForResult(i, CODE);
                        break;
                    }
                    case 1:{
                        Intent i = new Intent(getApplicationContext(), Screen3.class);
                        selectedName = "chula";
                        i.putExtra("image", selectedName);
                        startActivityForResult(i, CODE);

                        break;
                    }
                    case 2:{
                        Intent i = new Intent(getApplicationContext(), Screen3.class);
                        selectedName = "kaset";
                        i.putExtra("image", selectedName);
                        startActivityForResult(i, CODE);
                        break;
                    }
                    case 3: {
                        Intent i = new Intent(getApplicationContext(), Screen3.class);
                        selectedName = "abac";
                        i.putExtra("image", selectedName);
                        startActivityForResult(i, CODE);
                        break;
                    }
                    case 4:{
                        Intent i = new Intent(getApplicationContext(), Screen3.class);
                        selectedName = "stamford";
                        i.putExtra("image", selectedName);
                        startActivityForResult(i, CODE);
                        break;
                    }
                    default:{

                    }

                }
            }
        });
        listView.setAdapter(itemsAdapter);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CODE && resultCode == RESULT_OK) {
            String str = "You've rated " + selectedName + " for " + data.getIntExtra("starValue", 0) + " star(s)";
            Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
            Integer temporary = uniData.get(selectedName);
            uniData.put(selectedName,temporary + data.getIntExtra("starValue", 0));

            TextView textViewScreen2 = (TextView) findViewById(R.id.textViewScreen2);
            TextView textViewScreen3 = (TextView) findViewById(R.id.textView3);;
            TextView textViewScreen4 = (TextView) findViewById(R.id.textView4);
            TextView textViewScreen5 = (TextView) findViewById(R.id.textView5);;
            TextView textViewScreen6 = (TextView) findViewById(R.id.textView6);
            switch (selectedName){
                case "thammasat":{
                        thamScore += data.getIntExtra("starValue", 0);
                        textViewScreen2.setText("Thammasat University: " + uniData.get(selectedName));
                        break;
                }
                case "chula":{
                        chulaScore += data.getIntExtra("starValue", 0);
                        textViewScreen3.setText("Chulalongkorn University: " + uniData.get(selectedName));
                        break;
                }
                case "kaset":{
                    kasetScore += data.getIntExtra("starValue", 0);
                    textViewScreen4.setText("Kasetsart University: " + uniData.get(selectedName));
                    break;
                }
                case "abac":{
                    abacScore += data.getIntExtra("starValue", 0);
                    textViewScreen5.setText("Assumption University: "+ uniData.get(selectedName));
                    break;
                }
                case "stamford":{
                    stamford += data.getIntExtra("starValue", 0);
                    textViewScreen6.setText("Stamford University: " + uniData.get(selectedName));
                    break;
                }
                default:{
                    break;
                }
            }


        }
    }
}
