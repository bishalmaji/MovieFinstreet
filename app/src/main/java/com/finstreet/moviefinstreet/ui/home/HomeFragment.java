package com.finstreet.moviefinstreet.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.finstreet.moviefinstreet.DetailActivity;
import com.finstreet.moviefinstreet.adapter.MovieListAdapter;
import com.finstreet.moviefinstreet.databinding.FragmentHomeBinding;
import com.finstreet.moviefinstreet.model.Movie;

import java.util.List;

public class HomeFragment extends Fragment implements MovieListAdapter.ItemClickListener {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;
    private List<Movie> movieModelList;
    private MovieListAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final RecyclerView movie_recycler = binding.movieRecycler;
        adapter =  new MovieListAdapter(getContext(), movieModelList, this);
        movie_recycler.setLayoutManager(new GridLayoutManager(getContext(),2));
        movie_recycler.setHasFixedSize(true);
        movie_recycler.setAdapter(adapter);
        homeViewModel.makeApiCall("all");
        homeViewModel.getMovieListObserver().observe(getViewLifecycleOwner(), new Observer<List<Movie>>() {
            @Override
            public void onChanged(List<Movie> movies) {
                if(movies != null) {
                    movieModelList = movies;
                    adapter.setMovieList(movies);
                } else {
                    //show the no result page

                }
            }
        });
        return root;
    }




    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onMovieClick(Movie movie) {
        Intent intent=new Intent(getContext(), DetailActivity.class);
        intent.putExtra("name",movie.getShow().getName());
        intent.putExtra("img",movie.getShow().getImage().getOriginal());
        intent.putExtra("genr",movie.getShow().getGenres());
        intent.putExtra("lang",movie.getShow().getLanguage());
        intent.putExtra("rating",movie.getShow().getRating().getAverage());
        intent.putExtra("osite",movie.getShow().getOfficialSite());
        intent.putExtra("summery",movie.getShow().getSummary());
        startActivity(intent);
    }

}