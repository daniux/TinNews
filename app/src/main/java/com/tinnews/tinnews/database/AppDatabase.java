package com.tinnews.tinnews.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.tinnews.tinnews.retrofit.response.News;

/**
 * Created by dxie on 1/7/19.
 */
@Database(entities = {News.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract NewsDao newsDao();
}
