package com.example.roomdatabase;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

@SuppressWarnings("unchecked")
public final class HeroDao_Impl implements HeroDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfHero;

  public HeroDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfHero = new EntityInsertionAdapter<Hero>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Hero`(`id`,`name`,`realName`,`team`,`firstAppearance`,`createdBy`,`publisher`,`imageURL`,`bio`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Hero value) {
        stmt.bindLong(1, value.getId());
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getRealName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getRealName());
        }
        if (value.getTeam() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getTeam());
        }
        if (value.getFirstAppearance() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getFirstAppearance());
        }
        if (value.getCreatedBy() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getCreatedBy());
        }
        if (value.getPublisher() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getPublisher());
        }
        if (value.getImageURL() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getImageURL());
        }
        if (value.getBio() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getBio());
        }
      }
    };
  }

  @Override
  public void insert(Hero hero) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfHero.insert(hero);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }
}
