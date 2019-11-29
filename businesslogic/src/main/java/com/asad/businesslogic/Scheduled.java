package com.asad.businesslogic;

public class Scheduled implements MatchState {

    @Override
    public String getState() {
        return "scheduled";
    }

    @Override
    public void changeState(Match match) {
        MatchState state = new Live();
        match.setState(state);
    }


}
