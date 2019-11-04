package org.veloud.ratingservice.resource;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.veloud.ratingservice.models.Rating;
import org.veloud.ratingservice.models.UserRating;

@RestController
@RequestMapping("/ratingsdata")
public class RatingResource {
    @GetMapping(path="/{movieId}")
    public Rating getRating(@PathVariable("movieId") String movieId) {
        return new Rating(movieId, 5);
    }

    @GetMapping(path="users/{userId}")
    public UserRating getUserRating(@PathVariable("userId") String userId) {
        List<Rating> ratings = Arrays.asList(
                new Rating("1234", 5),
                new Rating("4321", 4)
        );
        UserRating userRating = new UserRating(ratings);
        return userRating;
    }
}
