package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;
@RestController
@RequestMapping("movies")
public class MovieController {
    @Autowired
    MovieService movieService;
    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody() Movie movie)
    {
        try
        {
            movieService.addmovie(movie);
            return new ResponseEntity<>("Success", HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody() Director director)
    {
        try
        {
            movieService.adddirector(director);
            return  new ResponseEntity<>("Success",HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("name")String moviename, @RequestParam("name")String directorname){
        try
        {
            movieService.addmoviedirectorpair(moviename, directorname);
            return  new ResponseEntity<>("Success",HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable("name")String name)
    {
            Movie movie = movieService.getmoviebyname(name);
            if(movie != null)
            {
                return  new ResponseEntity<>(movie,HttpStatus.OK);
            }
            else
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }
    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable("name")String name)
    {
        Director director = movieService.getdirectorbyname(name);
        if(director!=null)
            return new ResponseEntity<>(director,HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    @GetMapping("/get-movies-by-director-name/{name}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable("name")String name)
    {
        List<String> movienames = movieService.getMoviesByDirectorName(name);
        return new ResponseEntity<>(movienames,HttpStatus.OK);
    }
    @GetMapping("/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies()
    {
        List<String> movies = movieService.findAllMovies();
        return new ResponseEntity<>(movies,HttpStatus.OK);
    }
    @DeleteMapping("delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam String name)
    {
        movieService.deleteDirectorByName(name);
        return new ResponseEntity<>("Sucess",HttpStatus.OK);
    }
    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors()
    {
        movieService.deleteAllDirectors();
        return new ResponseEntity<>("Sucess",HttpStatus.OK);
    }
}
