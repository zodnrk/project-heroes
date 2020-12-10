package ch.bfh.zodnrk.promoter.client;


import ch.bfh.zodnrk.promoter.model.Party;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ArenaClientFallback implements ArenaClient {

    @Override
    public String battle(List<Party> challengers) {
        return "The arena is occupied at the moment!";
    }
}
