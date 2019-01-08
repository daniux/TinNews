package com.tinnews.tinnews.tin;

import android.annotation.SuppressLint;
import android.util.Log;

import com.tinnews.tinnews.TinApplication;
import com.tinnews.tinnews.database.AppDatabase;
import com.tinnews.tinnews.retrofit.NewsRequestApi;
import com.tinnews.tinnews.retrofit.RetrofitClient;
import com.tinnews.tinnews.retrofit.response.News;

import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by dxie on 1/7/19.
 */

public class TinModel implements TinContract.Model {
    //keep the reference of TinContract.Presenter
    private TinContract.Presenter presenter;
    //move the Retrofit client here
    private final NewsRequestApi newsRequestApi;

    //8.2 add db reference
    private final AppDatabase db;


    public TinModel() {
        newsRequestApi = RetrofitClient.getInstance().create(NewsRequestApi.class);
        //8.2 add db reference
        db = TinApplication.getDataBase();
    }


    @Override
    public void setPresenter(TinContract.Presenter presenter) {
        //assign the presenter
        this.presenter = presenter;
    }

    @Override
    public void fetchData() {
        //5.4 make the request in the Model
        newsRequestApi.getNewsByCountry("us")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .filter(baseResponse -> baseResponse != null && baseResponse.articles != null)
                .subscribe(baseResponse -> {
                    presenter.showNewsCard(baseResponse.articles);
                }, error -> {
                    Log.e("test", "error", error);
                });
    }

    //implement the saveFavoriteNews
    @SuppressLint("CheckResult")
    @Override
    public void saveFavoriteNews(News news) {
        Disposable disposable = Completable.fromAction(() -> db.newsDao().insertNews(news)).
                subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(() ->{

        }, error -> {
        });
    }
}