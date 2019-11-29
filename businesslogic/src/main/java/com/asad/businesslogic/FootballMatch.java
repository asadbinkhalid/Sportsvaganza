package com.asad.businesslogic;

public class FootballMatch extends Match {
    private int team1Score;
    private int team2Score;

    public FootballMatch(Team team1, Team team2, String date, String time, int team1Score, int team2Score) {
        super(team1, team2, date, time);
        this.team1Score = team1Score;
        this.team2Score = team2Score;
    }

    public int getTeam1Score() {
        return team1Score;
    }

    public void setTeam1Score(int team1Score) {
        this.team1Score = team1Score;
    }

    public int getTeam2Score() {
        return team2Score;
    }

    public void setTeam2Score(int team2Score) {
        this.team2Score = team2Score;
    }


}
