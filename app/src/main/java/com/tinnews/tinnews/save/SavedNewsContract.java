package com.tinnews.tinnews.save;

import com.tinnews.tinnews.mvp.MvpContract;
import com.tinnews.tinnews.retrofit.response.News;

import java.util.List;


//1.1 1.2 Create a new SavedNewsContract interface under save folder
public interface SavedNewsContract {
    interface View extends MvpContract.View<Presenter> {
        //3.2
        void loadSavedNews(List<News> newsList);
        // record position start
        boolean isViewEmpty();
        // record position stop
    }

    interface Presenter extends  MvpContract.Presenter<View, Model> {
        //3.2
        void loadSavedNews(List<News> newsList);

    }

    interface Model extends MvpContract.Model<Presenter> {
        //3.2
        void fetchData();

    }
}
