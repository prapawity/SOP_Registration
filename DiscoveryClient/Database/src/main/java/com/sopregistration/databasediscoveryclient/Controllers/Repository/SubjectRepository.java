package com.sopregistration.databasediscoveryclient.Controllers.Repository;

import com.sopregistration.databasediscoveryclient.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {
}
