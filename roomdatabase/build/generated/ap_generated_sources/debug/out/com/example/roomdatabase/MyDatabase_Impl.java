package com.example.roomdatabase;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.IllegalStateException;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;

@SuppressWarnings("unchecked")
public final class MyDatabase_Impl extends MyDatabase {
  private volatile HeroDao _heroDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Hero` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT, `realName` TEXT, `team` TEXT, `firstAppearance` TEXT, `createdBy` TEXT, `publisher` TEXT, `imageURL` TEXT, `bio` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"6d01842685d8692b4cadde5f069835bb\")");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `Hero`");
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      protected void validateMigration(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsHero = new HashMap<String, TableInfo.Column>(9);
        _columnsHero.put("id", new TableInfo.Column("id", "INTEGER", true, 1));
        _columnsHero.put("name", new TableInfo.Column("name", "TEXT", false, 0));
        _columnsHero.put("realName", new TableInfo.Column("realName", "TEXT", false, 0));
        _columnsHero.put("team", new TableInfo.Column("team", "TEXT", false, 0));
        _columnsHero.put("firstAppearance", new TableInfo.Column("firstAppearance", "TEXT", false, 0));
        _columnsHero.put("createdBy", new TableInfo.Column("createdBy", "TEXT", false, 0));
        _columnsHero.put("publisher", new TableInfo.Column("publisher", "TEXT", false, 0));
        _columnsHero.put("imageURL", new TableInfo.Column("imageURL", "TEXT", false, 0));
        _columnsHero.put("bio", new TableInfo.Column("bio", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysHero = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesHero = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoHero = new TableInfo("Hero", _columnsHero, _foreignKeysHero, _indicesHero);
        final TableInfo _existingHero = TableInfo.read(_db, "Hero");
        if (! _infoHero.equals(_existingHero)) {
          throw new IllegalStateException("Migration didn't properly handle Hero(com.example.roomdatabase.Hero).\n"
                  + " Expected:\n" + _infoHero + "\n"
                  + " Found:\n" + _existingHero);
        }
      }
    }, "6d01842685d8692b4cadde5f069835bb", "fade413015e59aa1ea08fe7bba34b41f");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    return new InvalidationTracker(this, "Hero");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `Hero`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public HeroDao mHeroDao() {
    if (_heroDao != null) {
      return _heroDao;
    } else {
      synchronized(this) {
        if(_heroDao == null) {
          _heroDao = new HeroDao_Impl(this);
        }
        return _heroDao;
      }
    }
  }
}
