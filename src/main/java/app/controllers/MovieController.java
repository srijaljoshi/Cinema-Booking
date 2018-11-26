package app.controllers;

import app.models.Movie;
import app.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MovieController {

    @Autowired
    private IMovieService movieService;

    @RequestMapping(value = {"search", "u/search"})
    public String searchMovie() {
        return "search-movie";
    }

    @RequestMapping(value = "/u/search_results")
    public @ResponseBody
    Object searchResults(@RequestParam("title") String title, Model model) {
//        model.addAttribute("movieSearchResults", movieService.findByTitle(title));
//        return "model";
        List<Movie> movies = movieService.findByTitle(title);

        System.out.println(">>> Find movie with Director >>> "  + movies.get(0).getDirector());
        return movies;
    }
}
