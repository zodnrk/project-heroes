package ch.bfh.zodnrk.promoter.client;


import ch.bfh.zodnrk.promoter.model.Party;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("camp-service")
public interface CampClient {

    @GetMapping("/createParty")
    public EntityModel<Party> createParty(@RequestParam(value = "name") String name);
}
