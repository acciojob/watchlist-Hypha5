package com.driver;

import org.springframework.stereotype.Component;
import java.util.*;
@Component
public class MovieRepository {
    private HashMap<String,Movie> movieList = new HashMap<>();
    private HashMap<String,Director> directorList = new HashMap<>();
    private HashMap<String,List<String>> movieDirectorHashMap = new HashMap<>();
    void addmovie(Movie movie)
    {
        movieList.put(movie.getName(),movie);
    }
    void  adddirector(Director director)
    {
        directorList.put(director.getName(),director);
    }
    void addmoviedirectorpair(String moviename, String directorname)
    {
        List<String> movies = movieDirectorHashMap.get(directorname);
        movies.add(moviename);
        movieDirectorHashMap.put(directorname,movies);
    }
    Movie getmoviebyname(String name)
    {
        return movieList.get(name);
    }
    Director getdirectorbyname(String name)
    {
        return directorList.get(name);
    }
    List<String> getMoviesByDirectorName(String name){
        List<String> movies = movieDirectorHashMap.get(name);
        return movies;


    }
    List<String> findAllMovies()
    {
        List<String> movies = new ArrayList<>();
        for(Map.Entry<String,Movie> e:movieList.entrySet())
        {
            movies.add(e.getKey());
        }
        return movies;
    }
    void deleteDirectorByName(String name)
    {

        List<String> movies = movieDirectorHashMap.get(name);
        for(String mname:movies)
        {
            movieList.remove(mname);
        }
        //Map.entrySet().removeIf(entry -> KeySet.contains(entry.getKey()) );
        directorList.remove(name);
        movieDirectorHashMap.remove(name);



    }
    void deleteAllDirectors()
    {
        directorList.clear();
        for(Map.Entry<String, List<String>> e :movieDirectorHashMap.entrySet())
        {
            List<String> temp = e.getValue();
            for(String mname:temp)
            {
                movieList.remove(mname);
            }
            //deleteformmovies(temp);
            //movieDirectorHashMap.remove(e);
        }
        movieDirectorHashMap.clear();

    }


}
