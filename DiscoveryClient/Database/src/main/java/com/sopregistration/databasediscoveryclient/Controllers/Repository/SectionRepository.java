package com.sopregistration.databasediscoveryclient.Controllers.Repository;

import antlr.collections.List;
import com.sopregistration.databasediscoveryclient.model.Section;
import com.sopregistration.databasediscoveryclient.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectionRepository extends JpaRepository<Section, String> {
}
