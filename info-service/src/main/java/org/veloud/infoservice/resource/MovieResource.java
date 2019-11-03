package org.veloud.infoservice.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.veloud.infoservice.models.Movie;

@RestController
@RequestMapping("/movies")
public class MovieResource {
    @GetMapping(path="/{movieId}")
    public Movie getMovieInfo(@PathVariable("movieId") String movieId) {
        return new Movie(movieId, "Die Hard");
    }
}
