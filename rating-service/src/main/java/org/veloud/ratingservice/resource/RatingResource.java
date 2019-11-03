package org.veloud.ratingservice.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.veloud.ratingservice.models.Rating;

@RestController
@RequestMapping("/ratingsdata")
public class RatingResource {
    @GetMapping(path="/{movieId}")
    public Rating getRating(@PathVariable("movieId") String movieId) {
        return new Rating(movieId, 5);
    }
}
