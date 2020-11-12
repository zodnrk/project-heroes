package ch.bfh.zodnrk.camp;

import ch.bfh.zodnrk.camp.model.Hero;
import ch.bfh.zodnrk.camp.model.Party;
import ch.bfh.zodnrk.camp.service.HeroService;
import ch.bfh.zodnrk.camp.service.PartyService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

@Component
public class CampApplicationRunner implements org.springframework.boot.ApplicationRunner {

    private final PartyService partyService;
    private final HeroService heroService;

    public CampApplicationRunner(PartyService partyService, HeroService heroService) {
        this.partyService = partyService;
        this.heroService = heroService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Party fellowship = partyService.createParty("The Fellowship");
        System.out.printf("Created party '%s' with %d members.%n",
                fellowship.getName(),
                fellowship.getMembers().size());

        Hero batteryMan = heroService.createHero("Battery Man");
        Hero wonderWoman = heroService.createHero("Wonder Women");

        System.out.printf("Created heroes '%s' and '%s'.%n",
                batteryMan.getName(),
                wonderWoman.getName());
    }
}
