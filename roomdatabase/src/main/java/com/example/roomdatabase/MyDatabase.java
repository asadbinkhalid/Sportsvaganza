package com.example.roomdatabase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = Hero.class, version = 1, exportSchema = false)
public abstract class MyDatabase extends RoomDatabase {
    private static final String DB_NAME = "my_db";
    private static MyDatabase instance;

    public static synchronized MyDatabase getInstance(Context context){
        if(instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), MyDatabase.class, DB_NAME)
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }

    public abstract HeroDao mHeroDao();


}