package com.sopregistration.databasediscoveryclient.Controllers.Repository;


import com.sopregistration.databasediscoveryclient.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
