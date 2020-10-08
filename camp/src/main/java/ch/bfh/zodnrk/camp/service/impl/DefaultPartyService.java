package ch.bfh.zodnrk.camp.service.impl;

import ch.bfh.zodnrk.camp.model.Hero;
import ch.bfh.zodnrk.camp.model.Party;
import ch.bfh.zodnrk.camp.service.HeroService;
import ch.bfh.zodnrk.camp.service.PartyService;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
public class DefaultPartyService implements PartyService {

    private static final int DEFAULT_PARTY_SIZE = 4;

    private final HeroService heroService;

    public DefaultPartyService(final HeroService heroService) {
        this.heroService = heroService;
    }

    @Override
    public Party createParty(final String partyName) {
        final List<Hero> members = new ArrayList<>(DEFAULT_PARTY_SIZE);
        for (int i = 0; i < DEFAULT_PARTY_SIZE; i++) {
            final String heroName = createHeroName(partyName, i);
            members.add(heroService.createHero(heroName));
        }

        final Party party = new Party();
        party.setName(partyName);
        party.setMembers(members);

        System.out.println("Party created: " + party.toString());

        return party;
    }

    private String createHeroName(final String partyName, final int heroNumber) {
        return String.format("Hero #%d of %s", heroNumber, partyName);
    }
}
