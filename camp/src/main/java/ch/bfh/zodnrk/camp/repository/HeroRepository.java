package ch.bfh.zodnrk.camp.repository;

import ch.bfh.zodnrk.camp.model.Hero;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface HeroRepository extends CrudRepository<Hero, String> {
    List<Hero> findByAtkGreaterThan(Integer atk);
}
