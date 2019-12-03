package com.example.roomdatabase;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity (tableName = "Hero")
public class Hero {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "realName")
    private String realName;

    @ColumnInfo(name = "team")
    private String team;

    @ColumnInfo(name = "firstAppearance")
    private String firstAppearance;

    @ColumnInfo(name = "createdBy")
    private String createdBy;

    @ColumnInfo(name = "publisher")
    private String publisher;

    @ColumnInfo(name = "imageURL")
    private String imageURL;

    @ColumnInfo(name = "bio")
    private String bio;


    public Hero(int id, String name, String realName, String team, String firstAppearance, String createdBy, String publisher, String imageURL, String bio) {
        this.id = id;
        this.name = name;
        this.realName = realName;
        this.team = team;
        this.firstAppearance = firstAppearance;
        this.createdBy = createdBy;
        this.publisher = publisher;
        this.imageURL = imageURL;
        this.bio = bio;
    }

    @Ignore
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

    public int getId() {
        return id;
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


