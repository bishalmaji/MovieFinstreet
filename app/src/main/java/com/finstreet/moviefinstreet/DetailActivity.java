package com.finstreet.moviefinstreet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Parcelable;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {
    TextView name,ratting,genres,lang,oSite,summery;
    ImageView movieImg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        name=findViewById(R.id.movieName);
        ratting=findViewById(R.id.movie_ratting);
        genres=findViewById(R.id.geners);
        lang=findViewById(R.id.movie_lang);
        oSite=findViewById(R.id.offical_site);
        summery=findViewById(R.id.summery);
        movieImg=findViewById(R.id.movie_image);

        name.setText( getIntent().getStringExtra("name"));
        double rating=getIntent().getDoubleExtra("rating",5.0);
        ratting.setText(String.valueOf(rating));
        lang.setText(getIntent().getStringExtra("lang"));
        oSite.setText(getIntent().getStringExtra("osite"));

        String substringSummery=getIntent().getStringExtra("summery").substring(3,getIntent().getStringExtra("summery").length()-4);
        summery.setText(substringSummery);
        Glide.with(this).load(getIntent().getStringExtra("img"))
        .into(movieImg);

        StringBuilder genrstr= new StringBuilder();
        ArrayList<String> gnrArr = getIntent().getStringArrayListExtra("genr");
        for (int i = 0; i <gnrArr.size(); i++) {
            genrstr.append(gnrArr.get(i)+", ");
        }
        genres.setText(genrstr);




    }
}