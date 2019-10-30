package com.asad.sportsvaganza.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.asad.sportsvaganza.R;

public class Activity2_gamesList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2_games_list);


<<<<<<< HEAD
        Button signup = findViewById(R.id.button_football);
        signup.setOnClickListener(new View.OnClickListener() {
=======
        Button football = findViewById(R.id.button_football);
        football.setOnClickListener(new View.OnClickListener() {
>>>>>>> e681d18ffb2a242a14b8e17d0032f5112ec79b42
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity2_gamesList.this, Activity3_football_main.class);
                startActivity(intent);
            }
        });

<<<<<<< HEAD
=======
        Button cricket = findViewById(R.id.button_cricket);
        cricket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity2_gamesList.this, Activity3_cricket_main.class);
                startActivity(intent);
            }
        });

>>>>>>> e681d18ffb2a242a14b8e17d0032f5112ec79b42
    }
}