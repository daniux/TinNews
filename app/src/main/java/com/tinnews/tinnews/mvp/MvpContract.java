package com.tinnews.tinnews.mvp;

/**
 * Created by dxie on 1/7/19.
 */

public interface MvpContract {
    interface View<P extends Presenter> {
        P getPresenter();
    }

    interface Presenter<V extends View, M extends Model> {
        void onCreate();

        void onDestroy();

        void onViewAttached(V view);

        void onViewDetached();
    }

    interface Model<P extends  Presenter> {
        void setPresenter(P presenter);
    }
}
