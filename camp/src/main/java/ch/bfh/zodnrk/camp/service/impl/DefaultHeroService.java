package ch.bfh.zodnrk.camp.service.impl;

import ch.bfh.zodnrk.camp.model.Hero;
import ch.bfh.zodnrk.camp.repository.HeroRepository;
import ch.bfh.zodnrk.camp.service.HeroService;

import java.util.Random;

public class DefaultHeroService implements HeroService {

    private static final double DEFAULT_HERO_HEALTH = 100.0;
    private final Random rng = new Random();
    private final HeroRepository heroRepository;

    public DefaultHeroService(HeroRepository heroRepository) {
        this.heroRepository = heroRepository;
    }

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
    public void printStrongHeroes(int atkLimit) {
        heroRepository.findByAtkGreaterThan(atkLimit).forEach(System.out::println);
    }
}
