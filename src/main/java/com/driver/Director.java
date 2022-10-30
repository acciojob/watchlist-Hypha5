package com.driver;

public class Director {
    String name;
    int numberOfMovies;
    double imdbRating;
    Director(){}
    Director(String name, int noofmovies, double rating)
    {
        this.name = name;
        this.numberOfMovies = noofmovies;
        this.imdbRating = rating;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImdbRating(double imdbRating) {
        this.imdbRating = imdbRating;
    }

    public void setNumberOfMovies(int numberOfMovies) {
        this.numberOfMovies = numberOfMovies;
    }

    public String getName() {
        return name;
    }

    public double getImdbRating() {
        return imdbRating;
    }

    public int getNumberOfMovies() {
        return numberOfMovies;
    }
}
