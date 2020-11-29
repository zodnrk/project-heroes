package ch.bfh.zodnrk.arena.controller;

import ch.bfh.zodnrk.arena.service.BattleService;
import ch.bfh.zodnrk.camp.model.Party;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArenaController {

    private final BattleService battleService;

    public ArenaController(BattleService battleService) {
        this.battleService = battleService;
    }

    @PostMapping(value = "/battle")
    public String battle(@RequestBody List<Party> challengers) {

        if (challengers.size() != 2) {
            throw new RuntimeException("Only 2 challengers at the same time are allowed in the arena.");
        }

        Party challengee = challengers.get(0);
        Party challenger = challengers.get(1);
        String winner = battleService.battle(challengee, challenger);
        return "The winner of the battle between '" + challengee.getName() + "' and '" + challenger.getName() + "' was '" + winner + "'!";
    }
}
