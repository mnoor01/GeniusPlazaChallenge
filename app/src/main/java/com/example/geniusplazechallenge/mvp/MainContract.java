package com.example.geniusplazechallenge.mvp;

import com.example.geniusplazechallenge.model.DataItem;

import java.util.List;

public interface MainContract {
    interface MainView {
        void putDataToRecyclerview(List<DataItem> dataItemList);
    }

    interface Presenter {
        void requestDataFromServer();
    }

    interface GetNoticeInteractor {
        interface OnFinishedListener {
            void onFinished(List<DataItem> dataItemList);

            void onFailure(Throwable throwable);
        }

        void getNoticeArraylist(OnFinishedListener onFinishedListener);
    }
}
