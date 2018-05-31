package com.example.alvin.firebase;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private String TAG = "FirebaseApplication";
    private EditText emailEdt;
    private EditText passwordEdt;

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mAuth = FirebaseAuth.getInstance();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                LinearLayout register = (LinearLayout) findViewById(R.id.email_password_buttons);
                LinearLayout chatroom = (LinearLayout) findViewById(R.id.signed_in_buttons);
                TextView status = (TextView) findViewById(R.id.status);

                if (user != null) {
                    // User is signed in
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                    register.setVisibility(View.GONE);
                    chatroom.setVisibility(View.VISIBLE);
                    status.setText("Hi, "+user.getEmail());
                    Toast.makeText(getApplicationContext(), "Signed In Successfully", Toast.LENGTH_SHORT).show();
                    emailEdt.setText("");
                    passwordEdt.setText("");
                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                    register.setVisibility(View.VISIBLE);
                    chatroom.setVisibility(View.GONE);
                    status.setText("Please sign-in or create an account.");
                }
                // ...
            }
        };
        emailEdt = (EditText) findViewById(R.id.field_email);
        passwordEdt = (EditText) findViewById(R.id.field_password);
    }
    public void createAccount(View view){
        String email = emailEdt.getText().toString();
        String password = passwordEdt.getText().toString();
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "createUserWithEmail:onComplete:" + task.isSuccessful());

                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Toast.makeText(MainActivity.this, R.string.auth_failed,
                                    Toast.LENGTH_SHORT).show();
                        } else{
                            Toast.makeText(MainActivity.this, "Register successfully",
                                    Toast.LENGTH_SHORT).show();
                            emailEdt.setText("");
                            passwordEdt.setText("");

                        }

                        // ...
                    }
                });
    }
    public void signIn(View view){
        String email = emailEdt.getText().toString();
        String password = passwordEdt.getText().toString();
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "signInWithEmail:onComplete:" + task.isSuccessful());

                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Log.w(TAG, "signInWithEmail:failed", task.getException());
                            Toast.makeText(MainActivity.this, R.string.auth_failed,
                                    Toast.LENGTH_SHORT).show();
                        }

                        // ...
                    }
                });

    }
    public void signOut(View view){
        FirebaseAuth.getInstance().signOut();
    }
    public void chatroom(View view){
        Intent intent = new Intent(MainActivity.this, ChatActivity.class);
        startActivity(intent);
    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }
}
