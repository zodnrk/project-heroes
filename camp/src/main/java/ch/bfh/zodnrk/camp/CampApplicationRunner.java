package ch.bfh.zodnrk.camp;

import ch.bfh.zodnrk.camp.repository.HeroRepository;
import ch.bfh.zodnrk.camp.service.HeroService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

@Component
public class CampApplicationRunner implements org.springframework.boot.ApplicationRunner {

    private final HeroService heroService;

    private final HeroRepository heroRepository;

    public CampApplicationRunner(HeroService heroService, HeroRepository heroRepository) {
        this.heroService = heroService;
        this.heroRepository = heroRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // initialize some data
        if (heroRepository.count() == 0) {
            heroService.createHero("Batman");
            heroService.createHero("Superman");
            heroService.createHero("Wolverine");
            heroService.createHero("Spiderman");
            heroService.createHero("Captain America");
            heroService.createHero("Iron Man");
            heroService.createHero("Hulk");
            heroService.createHero("Thor");
            heroService.createHero("Wonder Woman");
            heroService.createHero("Hawkeye");
        }
    }
}
