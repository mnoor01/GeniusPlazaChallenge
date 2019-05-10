package com.example.geniusplazechallenge.apiCall;

import com.example.geniusplazechallenge.model.DataItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiCall {
    @GET("api/users")
    Call<List<DataItem>> getDataItems();

    @POST("api/users")
    Call<List<DataItem>> putDataItem();


}
