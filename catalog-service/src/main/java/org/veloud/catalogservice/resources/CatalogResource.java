package org.veloud.catalogservice.resources;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.veloud.catalogservice.models.CatalogItem;
import org.veloud.catalogservice.models.Movie;
import org.veloud.catalogservice.models.Rating;

@RestController
@RequestMapping("/catalog")
public class CatalogResource {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(path="/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
        List<Rating> ratings = Arrays.asList(
                new Rating("1", 5),
                new Rating("2", 4)
        );
        return ratings.stream().map(rating -> {
            Movie movie = restTemplate.getForObject("http://localhost:8082/movies/" + rating.getMovieId(), Movie.class);
            return new CatalogItem(movie.getMovieId(), "Movie", rating.getRating());
        }).collect(Collectors.toList());
    }
}
