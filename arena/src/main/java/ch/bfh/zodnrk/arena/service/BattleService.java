package ch.bfh.zodnrk.arena.service;

import ch.bfh.zodnrk.camp.model.Party;

public interface BattleService {
    String battle(Party challengeeParty, Party challengerParty);
}