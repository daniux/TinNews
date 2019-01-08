package com.tinnews.tinnews.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;

import com.tinnews.tinnews.retrofit.response.News;

/**
 * Created by dxie on 1/7/19.
 */
@Dao
public interface NewsDao {
    @Insert
    void insertNews(News news);
}
