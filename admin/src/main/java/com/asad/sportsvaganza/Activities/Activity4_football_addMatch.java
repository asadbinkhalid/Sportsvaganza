package com.asad.sportsvaganza.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.asad.businesslogic.FootballMatch;
import com.asad.businesslogic.Team;
import com.asad.sportsvaganza.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Activity4_football_addMatch extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity4_football_addmatch);

        Button cricket = findViewById(R.id.add_match_done1);
        cricket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText etTeam1 = (EditText) findViewById(R.id.TI_team1name);
                String strTeam1 = etTeam1.getText().toString();
                EditText etTeam2 = (EditText) findViewById(R.id.TI_team2name);
                String strTeam2 = etTeam2.getText().toString();
                EditText etDate = (EditText) findViewById(R.id.TI_date);
                String strDate = etDate.getText().toString();
                EditText etTime = (EditText) findViewById(R.id.TI_time);
                String strTime = etTime.getText().toString();

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myReff = FirebaseDatabase.getInstance().getReference().child("FootballMatch");
                String key = database.getReference("FootballMatch").push().getKey();

                FootballMatch myTemp = new FootballMatch(new Team(strTeam1),new Team(strTeam2),strDate,strTime,0,0,key);

                myReff.push().setValue(myTemp);


                Intent intent = new Intent(Activity4_football_addMatch.this, Activity3_football_main.class);
                startActivity(intent);
            }


        });


    }
}
