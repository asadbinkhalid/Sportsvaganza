package com.asad.sportsvaganza.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import com.asad.businesslogic.CricketMatch;
import com.asad.businesslogic.Team;
import com.asad.sportsvaganza.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CricketAddMatchActivity extends AppCompatActivity {
    TimePicker timePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cricket_add_match);

        Button cricket = findViewById(R.id.add_match_done2);
        timePicker=(TimePicker)findViewById(R.id.timePicker2);
        timePicker.setIs24HourView(true);
        cricket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean check = true;

                EditText etTeam1 = (EditText) findViewById(R.id.TI_team1name);
                String strTeam1 = etTeam1.getText().toString();
                EditText etTeam2 = (EditText) findViewById(R.id.TI_team2name);
                String strTeam2 = etTeam2.getText().toString();
//                EditText etDate = (EditText) findViewById(R.id.TI_date);
//                String strDate = etDate.getText().toString();
//                EditText etTime = (EditText) findViewById(R.id.TI_time);
//                String strTime = etTime.getText().toString();
                DatePicker picker = (DatePicker)findViewById(R.id.datePicker2);
                String strDate = picker.getDayOfMonth() + "/" + picker.getMonth() + "/" + picker.getYear();
                String strTime = null;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                    strTime = timePicker.getHour() + ":" + timePicker.getMinute();
                }


                if(TextUtils.isEmpty(strTeam1)) {
                    etTeam1.setError("Team 1 Name Field Cannot Be Left Empty");
                    check = false;
                }
                if (TextUtils.isEmpty(strTeam2)){
                    etTeam2.setError("Team 2 Name Field Cannot Be Left Empty");
                    check = false;
                }

                if (check) {
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference myReff = FirebaseDatabase.getInstance().getReference().child("CricketMatch");
                    String key = database.getReference("CricketMatch").push().getKey();

                    CricketMatch myTemp = new CricketMatch(new Team(strTeam1),new Team(strTeam2),strDate,strTime,0,0,0,0,key);

                    myReff.push().setValue(myTemp);

                    Intent intent = new Intent(CricketAddMatchActivity.this, CricketMainActivity.class);
                    startActivity(intent);
                }
            }
        });

    }
}
