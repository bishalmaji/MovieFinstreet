package com.finstreet.moviefinstreet.model;

import com.finstreet.moviefinstreet.model.Country;
import com.finstreet.moviefinstreet.model.Show;

public class Movie{
    public double score;
    public Show show;

    public Movie(double score, Show show) {
        this.score = score;
        this.show = show;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }
}

