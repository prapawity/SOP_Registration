package com.sopregistration.databasediscoveryclient.Controllers.Repository;

import com.sopregistration.databasediscoveryclient.model.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Integer> {
}
