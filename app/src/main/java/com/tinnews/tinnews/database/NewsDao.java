package com.tinnews.tinnews.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.tinnews.tinnews.retrofit.response.News;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by dxie on 1/7/19.
 */
@Dao
public interface NewsDao {
    @Insert
    void insertNews(News news);

    //3.1
    @Query("SELECT * FROM news")
    Flowable<List<News>> getAll();

    //4.4
    @Query("DELETE FROM news")
    void deleteAllNews();


}
