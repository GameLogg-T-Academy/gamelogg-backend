package com.gamelogg.respositories;

import com.gamelogg.models.UserGame;
import com.gamelogg.models.UserGameId;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface UserGameRepository extends JpaRepository<UserGame, UserGameId>, JpaSpecificationExecutor<UserGame> {
    List<UserGame> findAll(Specification<UserGame> spec);
}
