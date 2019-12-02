package com.asad.businesslogic;

import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.room.Database;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private List<FootballMatch> footballMatches;
    private List<CricketMatch> cricketMatches;
    private static Main instance = null;

    private Main(){
         footballMatches = new ArrayList<>();
         cricketMatches = new ArrayList<>();
         initiateFootballMatches();
         initiateCricketMatches();
    }

    public static Main getInstance(){
        if(instance==null){
            instance = new Main();
        }
        return instance;
    }

    //write all backend functions in this Main class



//    public static void main(String[] args) {
//	// write your code here
//    }

    public void initiateFootballMatches(){
        final DatabaseReference reff;
        reff = FirebaseDatabase.getInstance().getReference("FootballMatch");
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                footballMatches.clear();
                for (DataSnapshot postSnapshot: snapshot.getChildren()) {
                    FootballMatch tempObj = new FootballMatch(postSnapshot.getValue(FootballMatch.class));
                    footballMatches.add(tempObj);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }


        });
    }

    public void updateFootballToLive(final FootballMatch tempFootballMatch)
    {
        final DatabaseReference reff;
        reff = FirebaseDatabase.getInstance().getReference("FootballMatch");
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                //footballMatches.clear();
                for (DataSnapshot postSnapshot: snapshot.getChildren()) {

                    final String key=postSnapshot.getKey();
                    reff.child(key).addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                            FootballMatch f=dataSnapshot.getValue(FootballMatch.class);

                            if(f.getMatchID().equals(tempFootballMatch.getMatchID()))
                            {
                                reff.child(key).child("state").setValue(Match.LIVE);
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
    }

    public void initiateCricketMatches(){

        Team asad = new Team("Asad 11");
        Team khawaja = new Team("Khawaja 11");
        String time1 = "14:30";
        String date1 = "02/10/2019";
        CricketMatch match1 = new CricketMatch(asad, khawaja, time1, date1, 0, 0, 0, 0,"true1");

        Team asad1 = new Team("FAST 11");
        Team khawaja1 = new Team("LUMS 11");
        String time2 = "15:00";
        String date2 = "02/10/2019";
        CricketMatch match2 = new CricketMatch(asad1, khawaja1, date2, time2, 0, 0, 0, 0,"true2");

        cricketMatches.add(match1);
        cricketMatches.add(match2);
    }




    public List<FootballMatch> getFootballMatchesList(){
        return footballMatches;
    }

    public List<CricketMatch> getCricketMatchesList(){
        return cricketMatches;
    }
}
