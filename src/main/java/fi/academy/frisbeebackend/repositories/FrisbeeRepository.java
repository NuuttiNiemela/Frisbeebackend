package fi.academy.frisbeebackend.repositories;

import fi.academy.frisbeebackend.Frisbee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "frisbees", path = "frisbees")
public interface FrisbeeRepository extends CrudRepository<Frisbee, Integer> {
    List<Frisbee> findByNameContainsIgnoreCase (@Param("haku") String haku);
    List<Frisbee> findById (@Param("haku") String haku);
    @Query("SELECT f FROM Frisbee f WHERE f.id = :id")
    Frisbee findOne (@Param("id") int id);
}
