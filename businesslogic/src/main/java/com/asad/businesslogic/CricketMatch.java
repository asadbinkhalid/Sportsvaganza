package com.asad.businesslogic;

public class CricketMatch extends Match {
    private int team1Runs;
    private int team2Runs;
    private int wickets;
    private int overs;

    public CricketMatch(Team team1, Team team2, String date, String time, int team1Runs, int team2Runs, int wickets, int overs,String ID) {
        super(team1, team2, date, time,ID);
        this.team1Runs = team1Runs;
        this.team2Runs = team2Runs;
        this.wickets = wickets;
        this.overs = overs;
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
