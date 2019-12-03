package com.asad.businesslogic;

import java.io.Serializable;

public class CricketMatch extends Match implements Serializable {
    private int team1Runs;
    private int team2Runs;
    private int wickets;
    private int overs;


    public CricketMatch()
    {
        super();
    }

    public CricketMatch(Team team1, Team team2, String date, String time, int team1Runs, int team2Runs, int wickets, int overs, String ID) {
        super(team1, team2, date, time,ID);
        this.team1Runs = team1Runs;
        this.team2Runs = team2Runs;
        this.wickets = wickets;
        this.overs = overs;
    }

    public CricketMatch(CricketMatch value)
    {
        super(value.getTeam1(),value.getTeam2(),value.getDate(),value.getTime(),value.getMatchID(),value.getState());
        team1Runs = value.getTeam1Runs();
        team2Runs = value.getTeam2Runs();
        wickets = value.getWickets();
        overs = value.getOvers();
    }

    public int getTeam1Runs() {
        return team1Runs;
    }

    public void setTeam1Runs(int team1Runs) {
        this.team1Runs = team1Runs;
    }

    public int getTeam2Runs() {
        return team2Runs;
    }

    public void setTeam2Runs(int team2Runs) {
        this.team2Runs = team2Runs;
    }

    public int getWickets() {
        return wickets;
    }

    public void setWickets(int wickets) {
        this.wickets = wickets;
    }

    public int getOvers() {
        return overs;
    }

    public void setOvers(int overs) {
        this.overs = overs;
    }
}
