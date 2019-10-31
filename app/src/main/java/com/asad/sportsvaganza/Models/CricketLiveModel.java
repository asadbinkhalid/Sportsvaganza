package com.asad.sportsvaganza.Models;

public class CricketLiveModel {
    public String teamA;
    public String teamB;
    public int target;
    public int runs;
    public int overs;
    public int wickets;

    public CricketLiveModel(String teamA, String teamB, int target, int runs, int wickets, int overs){
        this.teamA = teamA;
        this.teamB = teamB;
        this.target = target;
        this.runs = runs;
        this.wickets = wickets;
        this.overs = overs;
    }
}
