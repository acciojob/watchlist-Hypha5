package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class MovieService {
    @Autowired
        MovieRepository movieRepository;
        void addmovie(Movie movie)
        {
            movieRepository.addmovie(movie);
        }
        void adddirector(Director director)
        {
            movieRepository.adddirector(director);
        }
        void addmoviedirectorpair(String moviename, String directorname)
        {
            movieRepository.addmoviedirectorpair(moviename,directorname);
        }
        Movie getmoviebyname(String name)
        {
            return movieRepository.getmoviebyname(name);
        }
        Director getdirectorbyname(String name)
        {
            return movieRepository.getdirectorbyname(name);
        }
        List<String> getMoviesByDirectorName(String name)
        {
            return movieRepository.getMoviesByDirectorName(name);
        }
        List<String> findAllMovies()
        {
            return  movieRepository.findAllMovies();
        }
        void deleteDirectorByName(String name)
        {
            movieRepository.deleteDirectorByName(name);
        }
    void deleteAllDirectors()
    {
        movieRepository.deleteAllDirectors();
    }
}
