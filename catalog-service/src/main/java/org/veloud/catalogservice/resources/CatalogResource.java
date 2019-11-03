package org.veloud.catalogservice.resources;

import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.veloud.catalogservice.models.CatalogItem;

@RestController
@RequestMapping("/catalog")
public class CatalogResource {

    @GetMapping(path="/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
        return Collections.singletonList(
            new CatalogItem("Die Hard", "Action Movie", 5)
        );
    }
}
