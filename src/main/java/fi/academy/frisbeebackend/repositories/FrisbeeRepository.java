package fi.academy.frisbeebackend.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "frisbees", path = "frisbees")
public interface FrisbeeRepository extends CrudRepository<Frisbee, Integer> {
    List<Frisbee>
}
