package com.asad.businesslogic;

public class Match {
    private MatchState state;
    private Team team1;
    private Team team2;
    private String date;
    private String time;
    private int winnerID;

    public Match(Team team1, Team team2, String date, String time) {
        this.state = new Scheduled();
        this.team1 = team1;
        this.team2 = team2;
        this.date = date;
        this.time = time;
        winnerID = 0;
    }

    public String getState() {
        return state.getState();
    }

    public void setState(MatchState state) {
        this.state = state;
    }

    public Team getTeam1() {
        return team1;
    }

    public void setTeam1(Team team1) {
        this.team1 = team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public void setTeam2(Team team2) {
        this.team2 = team2;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void changeState(Match match)
    {
        state.changeState(this);
    }

    public int getWinnerID() {
        return winnerID;
    }

    public void setWinnerID(int winnerID) {
        this.winnerID = winnerID;
    }
}
