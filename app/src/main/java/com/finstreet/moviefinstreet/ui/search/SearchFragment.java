package com.finstreet.moviefinstreet.ui.search;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.finstreet.moviefinstreet.DetailActivity;
import com.finstreet.moviefinstreet.R;
import com.finstreet.moviefinstreet.adapter.MovieListAdapter;
import com.finstreet.moviefinstreet.adapter.SearchAdapter;
import com.finstreet.moviefinstreet.databinding.FragmentSearchBinding;
import com.finstreet.moviefinstreet.model.Movie;
import com.finstreet.moviefinstreet.network.MovieApi;
import com.finstreet.moviefinstreet.network.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SearchFragment extends Fragment implements SearchAdapter.ItemClickListener{

    private FragmentSearchBinding binding;

    private List<Movie> movieModelList;
    private SearchViewModel searchViewModel;
    private SearchAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentSearchBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        searchViewModel =new ViewModelProvider(getActivity()).get(SearchViewModel.class);
        final RecyclerView movie_recycler = binding.searchRecycler;
        adapter =  new SearchAdapter(getContext(), movieModelList, this);

        movie_recycler.setLayoutManager(new GridLayoutManager(getContext(),2));
        movie_recycler.setHasFixedSize(true);
        movie_recycler.setAdapter(adapter);

        searchViewModel.getMovieListObserver().observe(getViewLifecycleOwner(), new Observer<List<Movie>>() {
            @Override
            public void onChanged(List<Movie> movies) {
                Log.d("bkm", "obserb: ");
                if(movies != null) {
                    Log.d("bkm", "not null: ");
                    movieModelList = movies;
                    adapter.setMovieList(movies);
                    Log.d("bkm", "onChanged: ");
                } else {
                    //show the no result page
                    Log.d("bkm", "nodata: ");
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