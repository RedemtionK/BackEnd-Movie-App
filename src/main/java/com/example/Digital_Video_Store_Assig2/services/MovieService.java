package com.example.Digital_Video_Store_Assig2.services;

import com.example.Digital_Video_Store_Assig2.models.MovieModel;
import com.example.Digital_Video_Store_Assig2.models.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    private MovieRepository repository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<MovieModel> getMovies() {
        return repository.findAll();
    }

    public List<MovieModel> getOnlyMovies()

    {
        Query query = new Query();
        query.addCriteria(Criteria.where("Type" ).is("movie"));
        List<MovieModel> movies = mongoTemplate.find(query, MovieModel.class);
        return movies;
    }

    public List<MovieModel> getOnlyTvShows()

    {
        Query query = new Query();
        query.addCriteria(Criteria.where("Type" ).is("series"));
        List<MovieModel> tvShows = mongoTemplate.find(query, MovieModel.class);
        return tvShows;
    }
    public List<MovieModel> getFeaturedMovies(String featured)

    {


        Query query = new Query();
        query.addCriteria(Criteria.where("Featured" ).is(featured));
        query.addCriteria(Criteria.where("Type" ).is("movie"));
        List<MovieModel> movies = mongoTemplate.find(query, MovieModel.class);
        return movies;


    }

    public List<MovieModel> getFeaturedTvShows(String featured)

    {
        Query query = new Query();
        query.addCriteria(Criteria.where("Featured" ).is(featured));
        query.addCriteria(Criteria.where("Type" ).is("series"));
        List<MovieModel> movies = mongoTemplate.find(query, MovieModel.class);
        return movies;
    }

    public List<MovieModel> getByTitle(String title)

    {
        Query query = new Query();

        query.addCriteria(Criteria.where("Title" ).regex(title+".*","i"));
        List<MovieModel> movies = mongoTemplate.find(query, MovieModel.class);
        return movies;
    }

    public Optional<MovieModel> getAMovieById(String id) throws Exception {
        if(id.contains("a")||id.contains("b")||id.contains("c")||id.contains("d")||id.contains("e")||id.contains("f")||id.contains("g")||id.contains("h")||id.contains("i")||id.contains("j")||id.contains("k")||id.contains("l")||id.contains("m")||id.contains("n")||id.contains("o")||id.contains("p")||id.contains("q")||id.contains("r")||id.contains("s")||id.contains("t")||id.contains("u")||id.contains("v")||id.contains("y")||id.contains("x")||id.contains("z")||
                id.contains("A")||id.contains("B")||id.contains("C")||id.contains("D")||id.contains("E")||id.contains("F")||id.contains("G")||id.contains("H")||id.contains("I")||id.contains("J")||id.contains("K")||id.contains("L")||id.contains("M")||id.contains("N")||id.contains("O")||id.contains("P")||id.contains("Q")||id.contains("R")||id.contains("S")||id.contains("T")||id.contains("U")||id.contains("V")||id.contains("Y")||id.contains("X")||id.contains("Z")
                ||id.contains("!")||id.contains("@")||id.contains("#")||id.contains("$")||id.contains("%")||id.contains("^")||id.contains("&")||id.contains("*")||id.contains("(")||id.contains(")")||id.contains("-")||id.contains("_")||id.contains("+")||id.contains("=")||id.contains(";")||id.contains(":")||id.contains("'")||id.contains("<")||id.contains(">")||id.contains(",")||id.contains(".")||id.contains("/")||id.contains("?")||id.contains("|")||id.contains("~")||id.contains("`")
        ){
            throw new Exception("Id is not valid");
        }
        Optional<MovieModel> movie = repository.findById(id);
        if (!movie.isPresent()){
            throw  new Exception("Movie with id: "+id+" is not found");
        }
        return movie;
    }

    public void insertIntoMovies(MovieModel movie) {
        repository.insert(movie);


    }

    public void deleteMovie(String id) throws  Exception{
        if(id.contains("a")||id.contains("b")||id.contains("c")||id.contains("d")||id.contains("e")||id.contains("f")||id.contains("g")||id.contains("h")||id.contains("i")||id.contains("j")||id.contains("k")||id.contains("l")||id.contains("m")||id.contains("n")||id.contains("o")||id.contains("p")||id.contains("q")||id.contains("r")||id.contains("s")||id.contains("t")||id.contains("u")||id.contains("v")||id.contains("y")||id.contains("x")||id.contains("z")||
                id.contains("A")||id.contains("B")||id.contains("C")||id.contains("D")||id.contains("E")||id.contains("F")||id.contains("G")||id.contains("H")||id.contains("I")||id.contains("J")||id.contains("K")||id.contains("L")||id.contains("M")||id.contains("N")||id.contains("O")||id.contains("P")||id.contains("Q")||id.contains("R")||id.contains("S")||id.contains("T")||id.contains("U")||id.contains("V")||id.contains("Y")||id.contains("X")||id.contains("Z")
                ||id.contains("!")||id.contains("@")||id.contains("#")||id.contains("$")||id.contains("%")||id.contains("^")||id.contains("&")||id.contains("*")||id.contains("(")||id.contains(")")||id.contains("-")||id.contains("_")||id.contains("+")||id.contains("=")||id.contains(";")||id.contains(":")||id.contains("'")||id.contains("<")||id.contains(">")||id.contains(",")||id.contains(".")||id.contains("/")||id.contains("?")||id.contains("|")||id.contains("~")||id.contains("`")

        ){
            throw new Exception("Id is not valid");
        }
        repository.deleteById(id);
    }

    public MovieModel editMovie(String id, MovieModel newMovie) throws Exception {
        if(id.contains("a")||id.contains("b")||id.contains("c")||id.contains("d")||id.contains("e")||id.contains("f")||id.contains("g")||id.contains("h")||id.contains("i")||id.contains("j")||id.contains("k")||id.contains("l")||id.contains("m")||id.contains("n")||id.contains("o")||id.contains("p")||id.contains("q")||id.contains("r")||id.contains("s")||id.contains("t")||id.contains("u")||id.contains("v")||id.contains("y")||id.contains("x")||id.contains("z")||
                id.contains("A")||id.contains("B")||id.contains("C")||id.contains("D")||id.contains("E")||id.contains("F")||id.contains("G")||id.contains("H")||id.contains("I")||id.contains("J")||id.contains("K")||id.contains("L")||id.contains("M")||id.contains("N")||id.contains("O")||id.contains("P")||id.contains("Q")||id.contains("R")||id.contains("S")||id.contains("T")||id.contains("U")||id.contains("V")||id.contains("Y")||id.contains("X")||id.contains("Z")
                ||id.contains("!")||id.contains("@")||id.contains("#")||id.contains("$")||id.contains("%")||id.contains("^")||id.contains("&")||id.contains("*")||id.contains("(")||id.contains(")")||id.contains("-")||id.contains("_")||id.contains("+")||id.contains("=")||id.contains(";")||id.contains(":")||id.contains("'")||id.contains("<")||id.contains(">")||id.contains(",")||id.contains(".")||id.contains("/")||id.contains("?")||id.contains("|")||id.contains("~")||id.contains("`")

        ){
            throw new Exception("Id is not valid");
        }
        Optional<MovieModel> movie= repository.findById(id);


        movie.get().setTitle(newMovie.getTitle());
        movie.get().setYear(newMovie.getYear());
        movie.get().setFeatured(newMovie.getFeatured());
        movie.get().setPoster(newMovie.getPoster());
        movie.get().setDescription(newMovie.getDescription());
        movie.get().setBig(newMovie.getBig());
        movie.get().setRent(newMovie.getRent());
        movie.get().setBuy(newMovie.getBuy());

        if(movie.get().getTitle().isEmpty()||movie.get().getFeatured().isEmpty()||movie.get().getPoster().isEmpty()||movie.get().getDescription().isEmpty()
        ||movie.get().getBig().isEmpty()){
            throw new Exception("You cant leave empty Information when updating a Movie");
        }
        MovieModel updateMovie= repository.save(movie.get());
        return updateMovie;
    }
}
