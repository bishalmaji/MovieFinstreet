package com.finstreet.moviefinstreet.model;

public class Rating {
    public double average;

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public Rating(double average) {
        this.average = average;
    }
}
