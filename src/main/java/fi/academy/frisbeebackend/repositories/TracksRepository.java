package fi.academy.frisbeebackend.repositories;

import fi.academy.frisbeebackend.Tracks;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.domain.Pageable;
import java.util.List;

//TracksRepositoryn luonti. CRUD-toiminnot extendattu ja lisätty haut Id:n perusteella ja nimen perusteella,
// sekä apuhakija omalla queryllä, jotta saadaan oikean muotoinen olio tracks tietokannan muokkaukseen.
@RepositoryRestResource(collectionResourceRel = "tracks", path = "tracks")
public interface TracksRepository  extends PagingAndSortingRepository<Tracks, Integer> {

    Iterable<Tracks> findByFullnameContainsIgnoreCase (@Param("haku") String haku);

    List<Tracks> findById (@Param("haku") int haku);

    @Query("SELECT f FROM Tracks f WHERE f.id = :id")
    Tracks findOne (@Param("id") int id);

    Page<Tracks> findAll(Pageable pa);
}