package com.asad.sportsvaganza.Models;

public class CricketFixturesModel {
    public String teamA;
    public String teamB;
    public String date;
    public String time;

    public CricketFixturesModel(String teamA, String teamB, String time, String date){
        this.teamA = teamA;
        this.teamB = teamB;
        this.time = time;
        this.date = date;
    }

}
