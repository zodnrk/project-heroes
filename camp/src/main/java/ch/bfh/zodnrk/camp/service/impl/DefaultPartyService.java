package ch.bfh.zodnrk.camp.service.impl;

import ch.bfh.zodnrk.camp.model.Hero;
import ch.bfh.zodnrk.camp.model.Party;
import ch.bfh.zodnrk.camp.repository.HeroRepository;
import ch.bfh.zodnrk.camp.service.PartyService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class DefaultPartyService implements PartyService {

    private static final int DEFAULT_PARTY_SIZE = 4;
    private final HeroRepository heroRepository;

    public DefaultPartyService(final HeroRepository heroRepository) {
        this.heroRepository = heroRepository;
    }

    @Override
    public Party createParty(final String partyName) {
        final List<Hero> allHeroes = new ArrayList<>();
        heroRepository.findAll().forEach(allHeroes::add);
        Collections.shuffle(allHeroes);
        final List<Hero> members = allHeroes.subList(0, DEFAULT_PARTY_SIZE);

        final Party party = new Party();
        party.setName(partyName);
        party.setMembers(members);

        System.out.println("Party created: " + party.toString());
        return party;
    }
}
