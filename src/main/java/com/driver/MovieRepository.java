package com.driver;

import org.springframework.stereotype.Component;
import java.util.*;
@Component
public class MovieRepository {
    private List<Movie> movieList = new ArrayList<>();
    private List<Director> directorList = new ArrayList<>();
    private HashMap<String,List<String>> movieDirectorHashMap = new HashMap<>();
    void addmovie(Movie movie)
    {
        movieList.add(movie);
    }
    void  adddirector(Director director)
    {
        directorList.add(director);
    }
    void addmoviedirectorpair(String moviename, String directorname)
    {
        if(movieDirectorHashMap.containsKey(directorname))
        {
            List<String> curr = movieDirectorHashMap.get(directorname);
            curr.add(moviename);
            movieDirectorHashMap.put(directorname,curr);
        }
        else
        {
            List<String> curr = new ArrayList<>();
            curr.add(moviename);
            movieDirectorHashMap.put(directorname,curr);
        }
    }
    Movie getmoviebyname(String name)
    {
        for(Movie movie: movieList)
        {
            if(movie.name.equals(name))
            {
                return movie;
            }
        }
        return null;
    }
    Director getdirectorbyname(String name)
    {
        for(Director director: directorList)
        {
            if(director.name.equals(name))
            {
                return director;
            }
        }
        return null;
    }
    List<String> getMoviesByDirectorName(String name){
        List<String> movienames = new ArrayList<>();
        if(movieDirectorHashMap.containsKey(name))
        {
            movienames = movieDirectorHashMap.get(name);

        }
        return movienames;

    }
    List<String> findAllMovies()
    {
        List<String> movies = new ArrayList<>();
        for(Movie movie:movieList)
        {
            movies.add(movie.getName());
        }
        return movies;
    }
    void deleteDirectorByName(String name)
    {
        List<String> temp = new ArrayList<>();
        if(movieDirectorHashMap.containsKey(name))
        {
             temp = movieDirectorHashMap.get(name);
             deleteformmovies(temp);
            movieDirectorHashMap.remove(name);
        }
        for(Director director:directorList)
        {
            if(director.name.equals(name))
                directorList.remove(director);
        }

    }
    void deleteAllDirectors()
    {
        directorList.clear();
        for(Map.Entry<String, List<String>> e :movieDirectorHashMap.entrySet())
        {
            List<String> temp = e.getValue();
            deleteformmovies(temp);
            movieDirectorHashMap.remove(e);
        }

    }
    void deleteformmovies(List<String> temp)
    {
        for(String mname : temp)
        {
            for(Movie movie : movieList)
            {
                if(movie.getName().equals(mname))
                    movieList.remove(movie);
            }
        }
    }
}
