package com.example.alvin.firebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.text.format.DateFormat;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;


public class ChatActivity extends AppCompatActivity {
    private String TAG = "FirebaseApplication";
    private final String REF = "messages";
    FirebaseListAdapter<ChatMessage> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Hello, World!");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d(TAG, "Value is: " + value);
                TextView textView = (TextView) findViewById(R.id.welcomeTextView);
                textView.setText(value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

//get LIstVIew Data from here
        ListView listView = (ListView) findViewById(R.id.list_of_messages);
        adapter = new FirebaseListAdapter<ChatMessage>
                (this, ChatMessage.class,
                        R.layout.message,
                        FirebaseDatabase.
                                getInstance().
                                getReference(REF)){
            @Override
            protected void populateView(View v, ChatMessage model, int position) {
                TextView text = (TextView) v.findViewById(R.id.message_text);
                TextView user = (TextView) v.findViewById(R.id.message_user);
                TextView time = (TextView) v.findViewById(R.id.message_time);
                text.setText(model.getMessageText());
                user.setText(model.getMessageUser());
                time.setText(DateFormat.
                        format("dd-MM-yyyy (HH:mm:ss)",
                                model.getMessageTime()));
            };
        };
        listView.setAdapter(adapter);
    }
//get LIstVIew Data from here

    public void sendMessage(View view){
        EditText messageEdt = (EditText) findViewById(R.id.editText);
        String message = messageEdt.getText().toString();
        ChatMessage chat = new ChatMessage(message, FirebaseAuth.getInstance()
                .getCurrentUser()
                .getEmail());
        FirebaseDatabase.getInstance()
                .getReference(REF)
                .push()
                .setValue(chat);
        messageEdt.setText("");
    }
}
