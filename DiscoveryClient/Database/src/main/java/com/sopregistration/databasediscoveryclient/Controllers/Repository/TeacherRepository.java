package com.sopregistration.databasediscoveryclient.Controllers.Repository;

import com.sopregistration.databasediscoveryclient.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, String> {
}
