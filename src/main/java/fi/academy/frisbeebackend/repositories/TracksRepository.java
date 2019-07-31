package fi.academy.frisbeebackend.repositories;

import fi.academy.frisbeebackend.Frisbee;
import fi.academy.frisbeebackend.Tracks;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

//FrisbeeRepositoryn luonti. CRUD-toiminnot extendattu ja lisätty haut Id:n perusteella ja nimen perusteella,
// sekä apuhakija omalla queryllä, jotta saadaan oikean muotoinen olio frisbeen tietokanta muokkaukseen.
@RepositoryRestResource(collectionResourceRel = "tracks", path = "tracks")
public interface TracksRepository extends CrudRepository<Tracks, Integer> {
    List<Tracks> findByFullnameContainsIgnoreCase (@Param("haku") String haku);
    List<Tracks> findById (@Param("haku") int haku);
    @Query("SELECT f FROM Tracks f WHERE f.id = :id")
    Tracks findOne (@Param("id") int id);
}