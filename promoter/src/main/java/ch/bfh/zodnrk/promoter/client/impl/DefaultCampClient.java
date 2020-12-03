package ch.bfh.zodnrk.promoter.client.impl;

import ch.bfh.zodnrk.camp.model.Party;
import ch.bfh.zodnrk.promoter.client.CampClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@Component
public class DefaultCampClient implements CampClient {

    @Override
    public EntityModel<Party> createParty(String name) {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.put("Content-Type", List.of("application/json"));

        RequestEntity<String> request = new RequestEntity<>(
                "{\"name\":\"" + name + "\"}",
                headers,
                HttpMethod.POST,
                URI.create("http://localhost:8080/parties")
        );

        ResponseEntity<EntityModel<Party>> response = new RestTemplate().exchange(
                request, new ParameterizedTypeReference<EntityModel<Party>>() {
                });

        return response.getBody();
    }
}
