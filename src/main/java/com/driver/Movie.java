package com.driver;

public class Movie {
    String name;
    int durationInMinutes;
    double imdbRating;
    Movie(){}
    Movie(String name, int time,double rating)
    {
        this.name = name;
        this.durationInMinutes = time;
        this.imdbRating = rating;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public void setImdbRating(double imdbRating) {
        this.imdbRating = imdbRating;
    }

    public String getName() {
        return name;
    }

    public double getImdbRating() {
        return imdbRating;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }
}
