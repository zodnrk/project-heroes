package ch.bfh.zodnrk.promoter.client.impl;

import ch.bfh.zodnrk.camp.model.Party;
import ch.bfh.zodnrk.promoter.client.ArenaClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class DefaultArenaClient implements ArenaClient {

    @Override
    public String battle(List<Party> challangers) {
        ResponseEntity<String> response = new RestTemplate().exchange(
                "http://localhost:8083/battle",
                HttpMethod.POST,
                new HttpEntity<>(challangers),
                String.class);
        return response.getBody();
    }
}
