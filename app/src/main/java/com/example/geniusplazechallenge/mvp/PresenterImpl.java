package com.example.geniusplazechallenge.mvp;

import com.example.geniusplazechallenge.model.DataItem;

import java.util.List;

public class PresenterImpl implements MainContract.Presenter, MainContract.GetDataInteractor.OnFinishedListener {
    private MainContract.MainView view;
    private MainContract.GetDataInteractor interactor;

    public PresenterImpl(MainContract.MainView view, MainContract.GetDataInteractor interactor) {
        this.view = view;
        this.interactor = interactor;
    }

    @Override
    public void requestDataFromServer() {
    interactor.getNoticeArraylist(this);
    }

    @Override
    public void onFinished(List<DataItem> dataItemList) {
        view.putDataToRecyclerview(dataItemList);

    }

    @Override
    public void onFailure(Throwable throwable) {
        throwable.printStackTrace();

    }
}
