package com.sata.movieclip.Retrofit;

import com.sata.movieclip.Model.MovieListModel;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface ApiEndpoint {
    @GET("/") Call<MovieListModel> getData(
            @QueryMap Map<String, String> options
    );

}
