package com.asad.businesslogic;

import java.io.Serializable;

public class Team extends User implements Serializable {
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
