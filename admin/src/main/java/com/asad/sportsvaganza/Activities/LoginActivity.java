package com.asad.sportsvaganza.Activities;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;

import com.asad.businesslogic.Main;
import com.asad.sportsvaganza.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button signup = findViewById(R.id.button_login);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean check = true;
                EditText etUserName = (EditText) findViewById(R.id.username);
                String strUserName = etUserName.getText().toString();
                EditText etPass = (EditText) findViewById(R.id.password);
                String strPassword = etPass.getText().toString();

                if (strUserName.contains(" ")){
                    etUserName.setError("The Username Should Not Contain Any Spaces");
                    check = false;
                }
                if(TextUtils.isEmpty(strUserName)) {
                    etUserName.setError("Username Field Cannot Be Left Empty");
                    check = false;
                }
                if (TextUtils.isEmpty(strPassword)){
                    etPass.setError("Password Field Cannot Be Left Empty");
                    check = false;
                }

                if (check) {
                    mAuth.signInWithEmailAndPassword(strUserName, strPassword)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        Main.getInstance();

                                        Intent intent = new Intent(LoginActivity.this, GamesListActivity.class);
                                        startActivity(intent);
                                    }
                                    else {
                                        Toast.makeText(getApplicationContext(), "Login failed! Please try again later", Toast.LENGTH_LONG).show();
                                    }
                                }
                            });

                }


            }
        });
        FirebaseApp.initializeApp(getApplicationContext());
        mAuth = FirebaseAuth.getInstance();
    }
}
