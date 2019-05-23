package com.example.geniusplazechallenge.apiCall;

import com.example.geniusplazechallenge.model.DataItem;
import com.example.geniusplazechallenge.model.Response;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiCall {
    @GET("users")
    Call<Response> getDataItems();

    @POST("users")
    Call<List<DataItem>> putDataItem();


}
