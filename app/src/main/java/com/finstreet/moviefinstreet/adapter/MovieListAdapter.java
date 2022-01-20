package com.finstreet.moviefinstreet.adapter;


import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.finstreet.moviefinstreet.R;
import com.finstreet.moviefinstreet.model.Movie;

import java.util.List;

public class MovieListAdapter  extends RecyclerView.Adapter<MovieListAdapter.MyViewHolder> {
    private Context context;
    private List<Movie> movieList;
    private ItemClickListener clickListener;

    public MovieListAdapter(Context context, List<Movie> movieList, ItemClickListener clickListener) {
        this.context = context;
        this.movieList = movieList;
        this.clickListener = clickListener;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MovieListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_movie_list, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieListAdapter.MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.movieName.setText(this.movieList.get(position).getShow().getName());
        holder.ratting.setText(""+movieList.get(position).getShow().getRating().getAverage());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onMovieClick(movieList.get(position));
            }
        });
        Glide.with(context)
                .load(this.movieList.get(position).getShow().getImage().getMedium())
                .apply(RequestOptions.centerCropTransform())
                .into(holder.movieImage);
    }
    // method for filtering our recyclerview items.


    @Override
    public int getItemCount() {
        if(this.movieList != null) {
            return this.movieList.size();
        }
        return 0;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView movieName,ratting;
        ImageView movieImage;


        public MyViewHolder(View itemView) {
            super(itemView);
            movieName = (TextView)itemView.findViewById(R.id.movie_name);
            ratting=itemView.findViewById(R.id.ratting);
            movieImage = (ImageView)itemView.findViewById(R.id.movie_img);

        }
    }


    public interface ItemClickListener{
        public void onMovieClick(Movie movie);
    }
}
