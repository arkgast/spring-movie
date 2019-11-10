package org.veloud.catalogservice.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import org.veloud.catalogservice.models.CatalogItem;
import org.veloud.catalogservice.models.Movie;
import org.veloud.catalogservice.models.UserRating;

@RestController
@RequestMapping("/catalog")
public class CatalogResource {
    @Autowired
    private WebClient.Builder webClientBuilder;

    @Autowired
    private Logger logger;

    @GetMapping(path="/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
        UserRating userRating = webClientBuilder.build()
            .get()
            .uri("http://rating-service/ratingsdata/users/" + userId)
            .retrieve()
            .bodyToFlux(UserRating.class)
            .blockLast();

        return userRating.getUserRating()
            .stream()
            .map(rating -> {
                String url = "http://info-service/movies/";

                logger.info(rating.toString());

                Movie movie = webClientBuilder.build()
                    .get()
                    .uri(url + rating.getMovieId())
                    .retrieve()
                    .bodyToMono(Movie.class)
                    .block();

                return new CatalogItem(movie.getMovieId(), "Movie", rating.getRating());
            }).collect(Collectors.toList());
    }
}
