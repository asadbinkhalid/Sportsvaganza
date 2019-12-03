package com.example.roomdatabase;

import androidx.room.Dao;
import androidx.room.Insert;

@Dao
public interface HeroDao {

    @Insert
    void insert(Hero hero);


}
