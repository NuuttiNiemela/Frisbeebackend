package fi.academy.frisbeebackend.repositories;

import fi.academy.frisbeebackend.Frisbee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.List;

//FrisbeeRepositoryn luonti. CRUD-toiminnot extendattu ja lisätty haut Id:n perusteella ja nimen perusteella,
// sekä apuhakija omalla queryllä, jotta saadaan oikean muotoinen olio frisbeen tietokanta muokkaukseen.
@RepositoryRestResource(collectionResourceRel = "frisbees", path = "frisbees")
public interface FrisbeeRepository extends PagingAndSortingRepository<Frisbee, Integer> {
    
    List<Frisbee> findByNameContainsIgnoreCase (@Param("haku") String haku);

    List<Frisbee> findById (@Param("haku") String haku);

    @Query("SELECT f FROM Frisbee f WHERE f.id = :id")
    Frisbee findOne (@Param("id") int id);

    Page<Frisbee> findAll(Pageable p);
}
