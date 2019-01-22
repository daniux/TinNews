package com.tinnews.tinnews.profile;

import com.tinnews.tinnews.mvp.MvpContract;

/**
 * Created by dxie on 1/21/19.
 */

public interface ProfileContract {
    interface View extends MvpContract.View<Presenter> {
        void setView();

        void onCacheCleared();
    }

    interface Presenter extends MvpContract.Presenter<View, Model> {
        void onCacheCleared();

        android.view.View.OnClickListener getCacheClearListener();

        android.view.View.OnClickListener getOnCountryChangeListener(String country);
    }

    interface Model extends MvpContract.Model<Presenter> {
        void deleteAllNewsCache();

        void setDefaultCountry(String country);
    }
}
