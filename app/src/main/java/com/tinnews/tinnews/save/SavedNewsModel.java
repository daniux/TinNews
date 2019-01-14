package com.tinnews.tinnews.save;

import android.annotation.SuppressLint;

import com.tinnews.tinnews.TinApplication;
import com.tinnews.tinnews.database.AppDatabase;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class SavedNewsModel implements SavedNewsContract.Model {
    private SavedNewsContract.Presenter presenter;
    //3.4
    private final AppDatabase db;
    SavedNewsModel() {
        db = TinApplication.getDataBase();
    }


    @Override
    public void setPresenter(SavedNewsContract.Presenter presenter) {
        this.presenter = presenter;
    }


    //3.3
    @SuppressLint("CheckResult")
    @Override
    public void fetchData() {
        db.newsDao().getAll().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(presenter::loadSavedNews, error -> {
                    System.out.println("error");
                }, () -> {
                    System.out.println("complete");
                });
    }

}
