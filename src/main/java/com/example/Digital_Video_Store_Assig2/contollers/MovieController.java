package com.example.Digital_Video_Store_Assig2.contollers;

import com.example.Digital_Video_Store_Assig2.CustomizedResponse;
import com.example.Digital_Video_Store_Assig2.models.MovieModel;
import com.example.Digital_Video_Store_Assig2.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@CrossOrigin(origins={"http://localhost:3000","https://movie-app-klaus.herokuapp.com/"})
@RestController
public class MovieController {
    @Autowired
    private MovieService service;

    @GetMapping("/movies")
    public ResponseEntity getMovies()
    {
        var customizedResponse = new CustomizedResponse("A list of movies", service.getMovies());
        return new ResponseEntity(customizedResponse, HttpStatus.OK);
    }
    @GetMapping("/onlyMovies")
    public ResponseEntity getOnlyMovies()
    {
        var customizedResponse = new CustomizedResponse("A list of movies", service.getOnlyMovies());
        return new ResponseEntity(customizedResponse, HttpStatus.OK);
    }

    @GetMapping("/tvShows")
    public ResponseEntity getOnlyTvShows()
    {
        var customizedResponse = new CustomizedResponse("A list of TvShows", service.getOnlyTvShows());
        return new ResponseEntity(customizedResponse, HttpStatus.OK);
    }

    @GetMapping("/tvShows/Featured")
    public ResponseEntity getFeaturedTvShows(@RequestParam(value = "featured" )String featured)
    {
        var customizedResponse = new CustomizedResponse("A list of the featured tv-shows", service.getFeaturedTvShows(featured));
        return new ResponseEntity(customizedResponse, HttpStatus.OK);
    }

    @GetMapping("/onlyMovies/Featured")
    public ResponseEntity getFeaturedMovies(@RequestParam(value = "featured" )String featured)
    {
        var customizedResponse = new CustomizedResponse("A list of the featured movies", service.getFeaturedMovies(featured));
        return new ResponseEntity(customizedResponse, HttpStatus.OK);
    }

    @GetMapping("/movies/title")
    public ResponseEntity getByTitle(@RequestParam(value = "title" )String title)
    {
        var customizedResponse = new CustomizedResponse("A list of movies that contain the title", service.getByTitle(title));
        return new ResponseEntity(customizedResponse, HttpStatus.OK);
    }

    @DeleteMapping("/movies/{id}")
    public ResponseEntity deleteMovies(@PathVariable("id") String id)
    {
        CustomizedResponse customizedResponse = null;
        try {
            service.deleteMovie(id);
             customizedResponse = new CustomizedResponse("The movie with: "+id+" was deleted successfully !");

        } catch (Exception e) {
            customizedResponse = new CustomizedResponse(e.getMessage(),null);
            return  new ResponseEntity(customizedResponse,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(customizedResponse, HttpStatus.OK );

    }

    @GetMapping("/movies/{id}")
    public ResponseEntity getMovies(@PathVariable("id") String id)
    {
        CustomizedResponse customizedResponse = null;
        try {
            customizedResponse = new CustomizedResponse("The movie with id: "+id, Collections.singletonList(service.getAMovieById(id)));
        } catch (Exception e) {
            customizedResponse = new CustomizedResponse(e.getMessage(),null);
            return new ResponseEntity(customizedResponse,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(customizedResponse, HttpStatus.OK );

    }

    @PostMapping(value = "/movies", consumes = {
            MediaType.APPLICATION_JSON_VALUE
    })
    public  ResponseEntity addMovie(@RequestBody MovieModel movie){

        service.insertIntoMovies(movie);

        return new ResponseEntity(movie,HttpStatus.OK);

    }

    @PutMapping(value="/movies/{id}",consumes = {
            MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity editMovie(@PathVariable("id") String id,@RequestBody MovieModel newMovie){
        CustomizedResponse customizedResponse = null;
        try {
            customizedResponse = new CustomizedResponse("Movie with Id : "+id + " was updated successfully ! ", Collections.singletonList(service.editMovie(id, newMovie)));
        } catch (Exception e) {
            customizedResponse = new CustomizedResponse(e.getMessage(),null);
            return new ResponseEntity(customizedResponse,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(customizedResponse, HttpStatus.OK);
    }
}
