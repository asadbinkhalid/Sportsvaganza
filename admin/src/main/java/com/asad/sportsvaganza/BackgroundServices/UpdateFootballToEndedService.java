package com.asad.sportsvaganza.BackgroundServices;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.asad.businesslogic.FootballMatch;
import com.asad.businesslogic.Match;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UpdateFootballToEndedService extends IntentService {


    public UpdateFootballToEndedService() {
        super("end-match-service");
    }

    @Override
    public void onCreate() {
        super.onCreate(); // if you override onCreate(), make sure to call super().
        // If a Context object is needed, call getApplicationContext() here.
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        updateFootballToEnded( (FootballMatch) intent.getSerializableExtra("footballMatch"));
    }

    public void updateFootballToEnded(final FootballMatch tempFootballMatch) {
        final DatabaseReference reff;
        reff = FirebaseDatabase.getInstance().getReference("FootballMatch");
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                //footballMatches.clear();
                for (DataSnapshot postSnapshot : snapshot.getChildren()) {

                    final String key = postSnapshot.getKey();
                    reff.child(key).addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                            FootballMatch f = dataSnapshot.getValue(FootballMatch.class);

                            if (f.getMatchID().equals(tempFootballMatch.getMatchID())) {
                                reff.child(key).child("state").setValue(Match.ENDED);
                            }

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }


        });
        Log.d("asad", "End match service me firebase call ho raha haiiiiii");
    }

}
