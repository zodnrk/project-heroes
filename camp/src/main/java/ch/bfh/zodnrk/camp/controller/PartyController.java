package ch.bfh.zodnrk.camp.controller;

import ch.bfh.zodnrk.camp.model.Party;
import ch.bfh.zodnrk.camp.service.PartyService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/parties")
public class PartyController {
    private final PartyService partyService;

    public PartyController(PartyService partyService) {
        this.partyService = partyService;
    }

    @PostMapping
    public @ResponseBody
    Party create(@RequestBody HashMap<String, String> data) {
        Party party = partyService.createParty(data.get("name"));
        party.add(linkTo(methodOn(PartyController.class).create(data)).withSelfRel());
        party.getMembers().forEach(hero -> {
            party.add(linkTo(methodOn(HeroController.class).getById(hero.getId())).withRel("heroes"));
        });

        return party;
    }
}
