package com.example.geniusplazechallenge.mvp;

import android.util.Log;
import android.widget.Toast;

import com.example.geniusplazechallenge.apiCall.ApiCall;
import com.example.geniusplazechallenge.model.DataItem;
import com.example.geniusplazechallenge.networking.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class InteractorImpl implements MainContract.GetDataInteractor {


    @Override
    public void getNoticeArraylist(final OnFinishedListener onFinishedListener) {
        ApiCall call = RetrofitInstance.getRetrofit().create(ApiCall.class);
        Call<List<DataItem>> items = call.getDataItems();

        items.enqueue(new Callback<List<DataItem>>() {
            @Override
            public void onResponse(Call<List<DataItem>> call, Response<List<DataItem>> response) {

                if (response == null) {
                    Log.d("onResponse", "onResponse: " + response.body().toString());
                    onFinishedListener.onFinished(response.body());

                }
                Log.d("check call", "onResponse: " + response.body().get(0).getFirstName());
            }

            @Override
            public void onFailure(Call<List<DataItem>> call, Throwable t) {
                onFinishedListener.onFailure(t);

            }
        });

    }
}
