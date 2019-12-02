package com.asad.businesslogic;



public class Match {
    public static final String SCHEDULED = "scheduled";
    public static final String LIVE = "live";
    public static final String ENDED = "ended";

    //private MatchState state;
    String state;
    private Team team1;
    private Team team2;
    private String date;
    private String time;
    private int winnerID;
    private String matchID;

    public Match(Team team1, Team team2, String date, String time,String ID) {
        state = SCHEDULED;
        this.team1 = team1;
        this.team2 = team2;
        this.date = date;
        this.time = time;
        winnerID = 0;
        matchID = ID;
    }

    public Match(Team team1, Team team2, String date, String time,String ID,String tempState) {
        state = tempState;
        this.team1 = team1;
        this.team2 = team2;
        this.date = date;
        this.time = time;
        winnerID = 0;
        matchID = ID;
    }

    public String getMatchID() {
        return matchID;
    }

    public void setMatchID(String matchID) {
        this.matchID = matchID;
    }

    public Match()
    {

    }

//    public String getState() {
//        return state.getState();
//    }
//
//    public void setState(MatchState state) {
//        this.state = state;
//    }


    public String getState() {
        return this.state;
    }
    public void setState(String str){
        this.state = str;
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

//    public void changeState(Match match)
//    {
//        state.changeState(this);
//    }

    public int getWinnerID() {
        return winnerID;
    }

    public void setWinnerID(int winnerID) {
        this.winnerID = winnerID;
    }
}
