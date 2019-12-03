package com.asad.sportsvaganza.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.asad.sportsvaganza.R;
import com.google.firebase.auth.FirebaseAuth;

public class GamesListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games_list);

        Button football = findViewById(R.id.button_football);
        football.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GamesListActivity.this, FootballMainActivity.class);
                startActivity(intent);
            }
        });

        Button cricket = findViewById(R.id.button_cricket);
        cricket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GamesListActivity.this, CricketMainActivity.class);
                startActivity(intent);
            }
        });

        Button logout = findViewById(R.id.button14);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();

                Intent i = new Intent(GamesListActivity.this, LoginActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                Toast.makeText(getApplicationContext(), "Logged Out!", Toast.LENGTH_LONG).show();

                finish();
                startActivity(i);
            }
        });


    }
}