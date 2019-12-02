package com.asad.businesslogic;

public class FootballMatch extends Match {
    private int team1Score;
    private int team2Score;

    public FootballMatch(Team team1, Team team2, String date, String time, int team1Score, int team2Score,String ID) {
        super(team1, team2, date, time,ID);
        this.team1Score = team1Score;
        this.team2Score = team2Score;
    }
    public FootballMatch()
    {
        super();

    }

    public FootballMatch(FootballMatch value) {
        super(value.getTeam1(),value.getTeam2(),value.getDate(),value.getTime(),value.getMatchID(),value.getState());
        team1Score = value.team1Score;
        team1Score = value.team1Score;
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
