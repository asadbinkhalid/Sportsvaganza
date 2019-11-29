package com.asad.businesslogic;

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
        Team asad = new Team("Asad 11");
        Team khawaja = new Team("Khawaja 11");
        String time1 = "14:30";
        String date1 = "02/10/2019";
        FootballMatch match1 = new FootballMatch(asad, khawaja, date1, time1, 0, 0);

        Team asad1 = new Team("FAST 11");
        Team khawaja1 = new Team("LUMS 11");
        String time2 = "15:00";
        String date2 = "02/10/2019";
        FootballMatch match2 = new FootballMatch(asad1, khawaja1, date2, time2, 0, 0);


        footballMatches.add(match1);
        footballMatches.add(match2);
    }

    public void initiateCricketMatches(){

        Team asad = new Team("Asad 11");
        Team khawaja = new Team("Khawaja 11");
        String time1 = "14:30";
        String date1 = "02/10/2019";
        CricketMatch match1 = new CricketMatch(asad, khawaja, time1, date1, 0, 0, 0, 0);

        Team asad1 = new Team("FAST 11");
        Team khawaja1 = new Team("LUMS 11");
        String time2 = "15:00";
        String date2 = "02/10/2019";
        CricketMatch match2 = new CricketMatch(asad1, khawaja1, date2, time2, 0, 0, 0, 0);

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
