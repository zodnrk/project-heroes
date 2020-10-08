package ch.bfh.zodnrk.camp.service.impl;

import ch.bfh.zodnrk.camp.model.Hero;
import ch.bfh.zodnrk.camp.service.HeroService;

import javax.inject.Named;
import java.util.Random;

@Named
public class DefaultHeroService implements HeroService {

    private final Random rng = new Random();

    private static final double DEFAULT_HERO_HEALTH = 100.0;

    @Override
    public Hero createHero(final String name) {
        final Hero hero = new Hero();
        hero.setName(name);
        hero.setAtk(rng.nextInt(100) + 1);
        hero.setDef(rng.nextInt(100) + 1);
        hero.setHp(DEFAULT_HERO_HEALTH);

        System.out.println("Hero created: " + hero.toString());

        return hero;
    }
}
