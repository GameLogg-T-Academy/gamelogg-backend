package com.gamelogg.specifications;

import com.gamelogg.models.Game;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;

public class GameSpecification {
    public static Specification<Game> hasTitle(String title) {
        return ((root, query, criteriaBuilder) ->
                title == null? null : criteriaBuilder.like(criteriaBuilder
                        .lower(root.get("title")), "%" + title.toLowerCase() + "%"));
    }

    public static Specification<Game> isFavorite(Boolean favorite) {
        return ((root, query, criteriaBuilder) ->
                favorite == null? null : criteriaBuilder.equal(root.get("favorite"), favorite));
    }

    public static Specification<Game> hasStatus(String status) {
        return ((root, query, criteriaBuilder) ->
                status == null? null : criteriaBuilder.like(criteriaBuilder
                        .lower(root.get("status")), "%" + status.toLowerCase() + "%"));
    }

    public static Specification<Game> hasMaxPrice(Double maxPrice) {
        return ((root, query, criteriaBuilder) ->
                maxPrice == null? null : criteriaBuilder.lessThanOrEqualTo(root.get("price"), maxPrice));
    }

    public static Specification<Game> hasReleaseYear(Integer releaseYear) {
        return ((root, query, criteriaBuilder) ->
            releaseYear == null ? null : criteriaBuilder.equal(
                        criteriaBuilder.function("to_char", String.class,
                                                 root.get("releaseDate"),
                                                 criteriaBuilder.literal("YYYY")),
                        releaseYear.toString()));
    }

    public static Specification<Game> hasDeveloper(String developer) {
        return ((root, query, criteriaBuilder) ->
                developer == null? null : criteriaBuilder.like(criteriaBuilder
                        .lower(root.get("developer")), "%" + developer.toLowerCase() + "%"));
    }

    public static Specification<Game> hasPublisher(String publisher) {
        return ((root, query, criteriaBuilder) ->
                publisher == null? null : criteriaBuilder.like(criteriaBuilder
                        .lower(root.get("publisher")), "%" + publisher.toLowerCase() + "%"));
    }
}

