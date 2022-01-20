package com.finstreet.moviefinstreet.ui.search;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.finstreet.moviefinstreet.model.Movie;
import com.finstreet.moviefinstreet.network.MovieApi;
import com.finstreet.moviefinstreet.network.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SearchViewModel extends ViewModel {
    private MutableLiveData<List<Movie>> mMovies;

        public SearchViewModel() {
            mMovies = new MutableLiveData<>();

        }
        public MutableLiveData<List<Movie>> getMovieListObserver(){
            return mMovies;
        }


        public void makeApiCall(String str) {
            Retrofit retrofit = RetrofitClient.getRetrofitInstance();
            MovieApi api = retrofit.create(MovieApi.class);
            Call<List<Movie>> call = api.getMovies(str);
            call.enqueue(new Callback<List<Movie>>() {
                @Override
                public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                    mMovies.postValue(response.body());
                }

                @Override
                public void onFailure(Call<List<Movie>> call, Throwable t) {
                    mMovies.postValue(null);
                }
            });


        }
}