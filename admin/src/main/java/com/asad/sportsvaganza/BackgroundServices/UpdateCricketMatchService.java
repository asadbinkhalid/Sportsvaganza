package com.asad.sportsvaganza.BackgroundServices;

import android.app.IntentService;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.asad.businesslogic.CricketMatch;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UpdateCricketMatchService extends IntentService {
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public UpdateCricketMatchService() {
        super("cricket update service");
    }

    @Override
    public void onCreate() {
        super.onCreate(); // if you override onCreate(), make sure to call super().
        // If a Context object is needed, call getApplicationContext() here.
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        updateCricketMatch( (CricketMatch) intent.getSerializableExtra("cricketMatch"));
    }

    private void updateCricketMatch(final CricketMatch tempCricketMatch) {
        final DatabaseReference reff;
        reff = FirebaseDatabase.getInstance().getReference("CricketMatch");
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                //footballMatches.clear();
                for (DataSnapshot postSnapshot: snapshot.getChildren()) {

                    final String key=postSnapshot.getKey();
                    reff.child(key).addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                            CricketMatch f=dataSnapshot.getValue(CricketMatch.class);

                            if(f.getMatchID().equals(tempCricketMatch.getMatchID())) {
                                reff.child(key).child("state").setValue(tempCricketMatch.getState());
                                reff.child(key).child("team1Runs").setValue(tempCricketMatch.getTeam1Runs());
                                reff.child(key).child("team2Runs").setValue(tempCricketMatch.getTeam2Runs());
                                reff.child(key).child("overs").setValue(tempCricketMatch.getOvers());
                                reff.child(key).child("wickets").setValue(tempCricketMatch.getWickets());
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
    }
}
