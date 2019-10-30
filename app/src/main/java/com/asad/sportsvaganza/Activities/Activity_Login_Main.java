package com.asad.sportsvaganza.Activities;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.asad.sportsvaganza.R;

public class Activity_Login_Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button signup = findViewById(R.id.button_login);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_Login_Main.this, Activity2_gamesList.class);
                startActivity(intent);
            }
        });
    }
}
