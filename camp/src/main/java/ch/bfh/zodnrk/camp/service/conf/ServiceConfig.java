package ch.bfh.zodnrk.camp.service.conf;

import ch.bfh.zodnrk.camp.repository.HeroRepository;
import ch.bfh.zodnrk.camp.service.HeroService;
import ch.bfh.zodnrk.camp.service.PartyService;
import ch.bfh.zodnrk.camp.service.impl.DefaultHeroService;
import ch.bfh.zodnrk.camp.service.impl.DefaultPartyService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ServiceConfig {
    @Bean
    public HeroService heroService(HeroRepository heroRepository) {
        return new DefaultHeroService(heroRepository);
    }

    @Bean
    public PartyService partyService(final HeroService heroService) {
        return new DefaultPartyService(heroService);
    }
}
