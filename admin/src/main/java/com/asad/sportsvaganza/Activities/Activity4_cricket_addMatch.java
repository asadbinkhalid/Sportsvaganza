package com.asad.sportsvaganza.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.asad.sportsvaganza.R;

public class Activity4_cricket_addMatch extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity4_cricket_addmatch);

        Button cricket = findViewById(R.id.add_match_done2);
        cricket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent intent = new Intent(Activity4_cricket_addMatch.this, Activity3_cricket_main.class);
                startActivity(intent);
            }
        });

    }
}
