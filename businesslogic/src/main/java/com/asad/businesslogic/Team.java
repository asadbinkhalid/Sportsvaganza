package com.asad.businesslogic;

public class Team extends User {
    private String name;

    public Team(String name) {
        this.name = name;
    }

    public Team(){}
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
