package com.asad.sportsvaganza.Models;

public class FootballResultsModel {
    public String teamA1;
    public String teamB1;
    public String time1;
    public String date1;
    public String scoreA1;
    public String scoreB1;
    //public String hyphen;


    public FootballResultsModel(String teamA, String teamB, String scoreA, String scoreB, String time, String date){
        this.teamA1 = teamA;
        this.teamB1 = teamB;
        this.scoreA1 = scoreA;
        this.scoreB1 = scoreB;
        this.time1 = time;
        this.date1 = date;


    }

}
