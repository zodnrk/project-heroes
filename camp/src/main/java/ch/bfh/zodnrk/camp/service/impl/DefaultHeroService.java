package ch.bfh.zodnrk.camp.service.impl;

import ch.bfh.zodnrk.camp.model.Hero;
import ch.bfh.zodnrk.camp.repository.HeroRepository;
import ch.bfh.zodnrk.camp.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Named;
import java.util.Random;

@Named
public class DefaultHeroService implements HeroService {

    private static final double DEFAULT_HERO_HEALTH = 100.0;
    private final Random rng = new Random();
    @Autowired
    private HeroRepository heroRepository;

    @Override
    public Hero createHero(final String name) {
        final Hero hero = new Hero();
        hero.setName(name);
        hero.setAtk(rng.nextInt(100) + 1);
        hero.setDef(rng.nextInt(100) + 1);
        hero.setHp(DEFAULT_HERO_HEALTH);

        String id = heroRepository.save(hero).getId();

        System.out.println("Hero created: " + hero.toString());

        return heroRepository.findById(id).get();
    }

    @Override
    public void printStrongHeros(int atkLimit) {
        heroRepository.findByAtkGreaterThan(atkLimit).forEach(System.out::println);
    }
}
