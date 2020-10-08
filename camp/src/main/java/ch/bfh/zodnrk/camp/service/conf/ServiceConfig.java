package ch.bfh.zodnrk.camp.service.conf;

import ch.bfh.zodnrk.camp.service.HeroService;
import ch.bfh.zodnrk.camp.service.PartyService;
import ch.bfh.zodnrk.camp.service.impl.DefaultHeroService;
import ch.bfh.zodnrk.camp.service.impl.DefaultPartyService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan(basePackages = "ch.bfh.zodnrk.camp")
public class ServiceConfig {
    @Bean
    public HeroService heroService() {
        return new DefaultHeroService();
    }

    @Bean
    public PartyService partyService(final HeroService heroService) {
        return new DefaultPartyService(heroService);
    }
}
