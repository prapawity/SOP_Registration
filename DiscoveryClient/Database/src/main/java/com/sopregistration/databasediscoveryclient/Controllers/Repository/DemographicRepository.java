package com.sopregistration.databasediscoveryclient.Controllers.Repository;

        import com.sopregistration.databasediscoveryclient.model.Demographic;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.stereotype.Repository;

@Repository
public interface DemographicRepository extends JpaRepository<Demographic, String> {
}
