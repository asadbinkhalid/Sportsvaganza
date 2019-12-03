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
                    tempObj.setState(postSnapshot.getValue(FootballMatch.class).getState());
                    footballMatches.add(tempObj);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }


        });
    }

//    public void updateFootballToLive(final FootballMatch tempFootballMatch)
//    {
//        final DatabaseReference reff;
//        reff = FirebaseDatabase.getInstance().getReference("FootballMatch");
//        reff.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot snapshot) {
//                //footballMatches.clear();
//                for (DataSnapshot postSnapshot: snapshot.getChildren()) {
//
//                    final String key=postSnapshot.getKey();
//                    reff.child(key).addValueEventListener(new ValueEventListener() {
//                        @Override
//                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//
//                            FootballMatch f=dataSnapshot.getValue(FootballMatch.class);
//
//                            if(f.getMatchID().equals(tempFootballMatch.getMatchID()))
//                            {
//                                reff.child(key).child("state").setValue(Match.LIVE);
//                            }
//
//                        }
//
//                        @Override
//                        public void onCancelled(@NonNull DatabaseError databaseError) {
//
//                        }
//                    });
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//
//
//        });
//    }
//
//    public void updateFootballToEnded(final FootballMatch tempFootballMatch) {
//        final DatabaseReference reff;
//        reff = FirebaseDatabase.getInstance().getReference("FootballMatch");
//        reff.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot snapshot) {
//                //footballMatches.clear();
//                for (DataSnapshot postSnapshot : snapshot.getChildren()) {
//
//                    final String key = postSnapshot.getKey();
//                    reff.child(key).addValueEventListener(new ValueEventListener() {
//                        @Override
//                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//
//                            FootballMatch f = dataSnapshot.getValue(FootballMatch.class);
//
//                            if (f.getMatchID().equals(tempFootballMatch.getMatchID())) {
//                                reff.child(key).child("state").setValue(Match.ENDED);
//                            }
//
//                        }
//
//                        @Override
//                        public void onCancelled(@NonNull DatabaseError databaseError) {
//
//                        }
//                    });
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//
//
//        });
//    }

    public void initiateCricketMatches(){
        final DatabaseReference reff;
        reff = FirebaseDatabase.getInstance().getReference("CricketMatch");
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                cricketMatches.clear();
                for (DataSnapshot postSnapshot: snapshot.getChildren()) {
                    CricketMatch tempObj = new CricketMatch(postSnapshot.getValue(CricketMatch.class));
                    cricketMatches.add(tempObj);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }


        });
    }



    public List<FootballMatch> getFootballMatchesList(){
        return footballMatches;
    }

    public List<CricketMatch> getCricketMatchesList(){
        return cricketMatches;
    }
}
