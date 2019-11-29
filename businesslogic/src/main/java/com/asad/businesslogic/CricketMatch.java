package com.asad.businesslogic;

public class CricketMatch extends Match {
    private int team1Runs;
    private int team1Wickets;
    private int team2Runs;
    private int team2Wickets;

    public CricketMatch(Team team1, Team team2, String date, String time, int team1Runs, int team1Wickets, int team2Runs, int team2Wickets) {
        super(team1, team2, date, time);
        this.team1Runs = team1Runs;
        this.team1Wickets = team1Wickets;
        this.team2Runs = team2Runs;
        this.team2Wickets = team2Wickets;
    }

    public int getTeam1Runs() {
        return team1Runs;
    }

    public void setTeam1Runs(int team1Runs) {
        this.team1Runs = team1Runs;
    }

    public int getTeam1Wickets() {
        return team1Wickets;
    }

    public void setTeam1Wickets(int team1Wickets) {
        this.team1Wickets = team1Wickets;
    }

    public int getTeam2Runs() {
        return team2Runs;
    }

    public void setTeam2Runs(int team2Runs) {
        this.team2Runs = team2Runs;
    }

    public int getTeam2Wickets() {
        return team2Wickets;
    }

    public void setTeam2Wickets(int team2Wickets) {
        this.team2Wickets = team2Wickets;
    }
}
