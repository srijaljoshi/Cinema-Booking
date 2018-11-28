package app.controllers;

import app.models.Movie;
import app.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MovieController {

    @Autowired
    private IMovieService movieService;

    final static int NOW_PLAYING = 1;
    final static int COMING_SOON = 0;

    /**
     * Get movies from the database to show on the home page
     * @return
     */
    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("movies", movieService.listMovies());
        return "home";
    }

    @RequestMapping(value = {"search", "u/search"})
    public String searchMovie() {
        return "movie-search";
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

    @RequestMapping("/movie/{id}")
    public String movieDetails(@PathVariable("id") Integer id, Model model) {
        model.addAttribute(movieService.findById(id));
        System.out.println(">>> found movie with id: " + id);
        return "movie-details";
    }

    @RequestMapping("/movies_playing")
    public String nowPlaying(Model model) {
        model.addAttribute("movies", movieService.listMoviesByPlaying(NOW_PLAYING));
        return "movies-now-playing";
    }

    @RequestMapping("/coming_soon")
    public String comingSoon(Model model) {
        model.addAttribute("movies", movieService.listMoviesByPlaying(COMING_SOON));
        return "movies-now-playing";
    }

}
