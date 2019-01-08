package com.tinnews.tinnews.tin;


import com.tinnews.tinnews.mvp.MvpContract;
import com.tinnews.tinnews.retrofit.response.News;

import java.util.List;

public interface TinContract {
    interface View extends MvpContract.View<Presenter> {
        void showNewsCard(List<News> newsList);
    }

    interface Presenter extends MvpContract.Presenter<View, Model> {
        //5.6 add showNewsCard
        void showNewsCard(List<News> newsList);
        //8.1
        void saveFavoriteNews(News news);

    }

    interface Model extends MvpContract.Model<Presenter> {
        //add fetchData here
        void fetchData();
        //8.1
        void saveFavoriteNews(News news);

    }

}
