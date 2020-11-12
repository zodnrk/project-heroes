package ch.bfh.zodnrk.camp;

import ch.bfh.zodnrk.camp.model.Party;
import ch.bfh.zodnrk.camp.service.PartyService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

@Component
public class CampApplicationRunner implements org.springframework.boot.ApplicationRunner {

    private final PartyService partyService;

    public CampApplicationRunner(PartyService partyService) {
        this.partyService = partyService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Party fellowship = partyService.createParty("The Fellowship");

        System.out.printf("Created party '%s' with %d members.%n", fellowship.getName(), fellowship.getMembers().size());
    }
}
