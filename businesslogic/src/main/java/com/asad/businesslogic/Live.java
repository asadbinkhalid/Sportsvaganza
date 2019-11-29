package com.asad.businesslogic;

public class Live implements MatchState {
    public String getState(){
        return "live";
    }

    @Override
    public void changeState(Match match) {
        MatchState state = new Ended();
        match.setState(state);
    }
}
