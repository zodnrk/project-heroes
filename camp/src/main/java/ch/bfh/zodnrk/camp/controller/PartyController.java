package ch.bfh.zodnrk.camp.controller;

import ch.bfh.zodnrk.camp.model.Party;
import ch.bfh.zodnrk.camp.service.PartyService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class PartyController {
    private final PartyService partyService;

    public PartyController(PartyService partyService) {
        this.partyService = partyService;
    }

    @GetMapping(value = "createParty")
    public Party create(@RequestParam String name) {
        Party party = partyService.createParty(name);
        party.add(linkTo(methodOn(PartyController.class).create(name)).withSelfRel());
        party.getMembers().forEach(hero -> {
            party.add(linkTo(methodOn(HeroController.class).getById(hero.getId())).withRel("heroes"));
        });

        return party;
    }
}
