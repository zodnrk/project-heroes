package ch.bfh.zodnrk.camp.repository;

import ch.bfh.zodnrk.camp.model.Hero;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HeroRepository extends CrudRepository<Hero, String> {
    List<Hero> findByAtkGreaterThan(Integer atk);


}
