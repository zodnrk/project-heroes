package ch.bfh.zodnrk.promoter.client;

import ch.bfh.zodnrk.camp.model.Party;
import org.springframework.hateoas.EntityModel;

public interface CampClient {
    public EntityModel<Party> createParty(String name);
}
