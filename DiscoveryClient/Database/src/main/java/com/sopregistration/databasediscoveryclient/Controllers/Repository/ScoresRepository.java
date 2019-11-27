package com.sopregistration.databasediscoveryclient.Controllers.Repository;

import com.sopregistration.databasediscoveryclient.model.Scores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ScoresRepository extends JpaRepository<Scores, Integer> {
}
