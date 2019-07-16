package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {

    @Autowired
    ActorRepository actorRepository;

    @Autowired
    MovieRepository movieRepository;

    @RequestMapping("/")
    public String index(Model model){
        //First let's create an actor
        Actor actor = new Actor();
        actor.setName("Sandra Bullock");
        actor.setRealname("Sandra Mae Bullowski");

        //First let's create an actor
        Actor actor2 = new Actor();
        actor2.setName("Tom Hanks");
        actor2.setRealname("Timothy Hankanson");

        //Now let's create a movie
        Movie movie = new Movie();
        movie.setTitle("Emoji Movie");
        movie.setYear(2017);
        movie.setDescription("About Emojies...");

        //Add a second Movie
        Movie movie2 = new Movie();
        movie2.setTitle("Pretty Woman");
        movie2.setYear(1990);
        movie2.setDescription("About a Pretty Women...");

        //Add a third Movie
        Movie movie3 = new Movie();
        movie3.setTitle("Toy Story");
        movie3.setYear(1990);
        movie3.setDescription("About a Toy's Story...");

        //Add the movies for Sandra Bullock to an empty list
        Set<Movie> movies = new HashSet<Movie>();
        movies.add(movie);
        movies.add(movie2);
        movies.add(movie3);

        //Add movies for Tom Hanks to another empty list
        Set<Movie> movies2 = new HashSet<Movie>();
        movies2.add(movie3);

        //Add the list of movies to the Sandra Bullock's movie list
        actor.setMovies(movies);

        //Add the list of movies to the Tom Hanks movie list
        actor2.setMovies(movies2);

        //Save the actor to the database
        actorRepository.save(actor);

        //Save the actor to the database
        actorRepository.save(actor2);

        //Grab all the actors from the database and send them to the template
        model.addAttribute("actors", actorRepository.findAll());
        return "index";

    }

}
