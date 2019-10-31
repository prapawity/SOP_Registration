package com.sopregistration.databasediscoveryclient.Controllers.Repository;

import com.sopregistration.databasediscoveryclient.model.SectionChecked;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SectionCheckRepository extends JpaRepository<SectionChecked, Integer> {
}
