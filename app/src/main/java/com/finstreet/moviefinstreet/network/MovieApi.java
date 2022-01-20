package com.finstreet.moviefinstreet.network;

import com.finstreet.moviefinstreet.model.Movie;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface MovieApi {

    @GET("search/shows")
    Call<List<Movie>> getMovies(@Query("q") String  str);
}
