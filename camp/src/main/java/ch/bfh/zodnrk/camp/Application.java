package ch.bfh.zodnrk.camp;

import ch.bfh.zodnrk.camp.model.Party;
import ch.bfh.zodnrk.camp.service.HeroService;
import ch.bfh.zodnrk.camp.service.PartyService;
import ch.bfh.zodnrk.camp.service.conf.ServiceConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ServiceConfig.class);

        final PartyService partyService = context.getBean(PartyService.class);
        final HeroService heroService = context.getBean(HeroService.class);
        Party fellowship = partyService.createParty("The Fellowship");

        System.out.printf("Created party '%s' with %d members.%n", fellowship.getName(), fellowship.getMembers().size());
        heroService.printStrongHeroes(50);
        context.close();
    }
}
