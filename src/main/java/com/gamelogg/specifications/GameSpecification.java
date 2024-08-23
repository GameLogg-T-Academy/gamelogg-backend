package com.gamelogg.specifications;

import com.gamelogg.models.Game;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;

public class GameSpecification {
    public static Specification<Game> hasId(Long id) {
        return (root, query, criteriaBuilder) ->
                id == null ? null: criteriaBuilder.equal(root.get("id"), id);
    }
    public static Specification<Game> hasTitle(String title) {
        return ((root, query, criteriaBuilder) ->
                title == null? null : criteriaBuilder.like(criteriaBuilder
                        .lower(root.get("title")), "%" + title.toLowerCase() + "%"));
    }

    public static Specification<Game> hasDurationRange(Integer durationMin, Integer durationMax) {
        return ((root, query, criteriaBuilder) -> {
            if (durationMin!= null && durationMax!= null)
                return criteriaBuilder.between(root.get("duration"), durationMin, durationMax);
            else if (durationMin!= null)
                return criteriaBuilder.greaterThanOrEqualTo(root.get("duration"), durationMin);
            else if (durationMax!= null)
                return criteriaBuilder.lessThanOrEqualTo(root.get("duration"), durationMax);
            else
                return null;
        });
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

    public static Specification<Game> hasReleaseDateRange(LocalDate releaseBefore, LocalDate releaseAfter) {
        return ((root, query, criteriaBuilder) -> {
            if (releaseBefore!= null && releaseAfter!= null)
                return criteriaBuilder.between(root.get("releaseDate"), releaseBefore, releaseAfter);
            else if (releaseBefore!= null)
                return criteriaBuilder.lessThanOrEqualTo(root.get("releaseDate"), releaseBefore);
            else if (releaseAfter!= null)
                return criteriaBuilder.greaterThanOrEqualTo(root.get("releaseDate"), releaseAfter);
            else
                return null;
        });
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

