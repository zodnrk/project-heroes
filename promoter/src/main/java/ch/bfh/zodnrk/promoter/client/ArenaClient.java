package ch.bfh.zodnrk.promoter.client;

import ch.bfh.zodnrk.camp.model.Party;

import java.util.List;

public interface ArenaClient {
    String battle(List<Party> challengers);
}
