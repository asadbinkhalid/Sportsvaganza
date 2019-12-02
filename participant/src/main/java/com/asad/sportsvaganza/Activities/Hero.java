package com.asad.sportsvaganza.Activities;

public class Hero {
    private String name;
    private String realName;
    private String team;
    private String firstAppearance;
    private String createdBy;
    private String publisher;
    private String imageURL;
    private String bio;

    public Hero(String name, String realName, String team, String firstAppearance, String createdBy, String publisher, String imageURL, String bio) {
        this.name = name;
        this.realName = realName;
        this.team = team;
        this.firstAppearance = firstAppearance;
        this.createdBy = createdBy;
        this.publisher = publisher;
        this.imageURL = imageURL;
        this.bio = bio;
    }

    public String getName() {
        return name;
    }

    public String getRealName() {
        return realName;
    }

    public String getTeam() {
        return team;
    }

    public String getFirstAppearance() {
        return firstAppearance;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getImageURL() {
        return imageURL;
    }

    public String getBio() {
        return bio;
    }
}


