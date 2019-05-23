package com.example.geniusplazechallenge.mvp;

import android.util.Log;
import android.widget.Toast;

import com.example.geniusplazechallenge.apiCall.ApiCall;
import com.example.geniusplazechallenge.model.DataItem;
import com.example.geniusplazechallenge.model.Response;
import com.example.geniusplazechallenge.networking.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;


public class InteractorImpl implements MainContract.GetDataInteractor {


    @Override
    public void getNoticeArraylist(final OnFinishedListener onFinishedListener) {
        ApiCall call = RetrofitInstance.getRetrofit().create(ApiCall.class);
        Call<Response> items = call.getDataItems();
        items.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                if (response != null) {
                    Log.d("onResponse", "onResponse: " + response.body().toString());
                        onFinishedListener.onFinished(response.body().getData());
                }
//                Log.d("check call", "onResponse: " + response.body().get(0).getFirstName());
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {

            }
        });


    }
}
