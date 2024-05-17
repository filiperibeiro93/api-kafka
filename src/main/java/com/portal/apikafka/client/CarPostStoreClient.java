package com.portal.apikafka.client;

import com.portal.apikafka.dto.CarPostDto;
import com.portal.apikafka.dto.OwnerPostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Component
public class CarPostStoreClient {

    private final String USER_STORE_SERVICE_URI = "http://localhost:8080/user";
    private final String POST_STORE_SERVICE_URI = "http://localhost:8080/sales";

    private final RestTemplate restTemplate;

    @Autowired
    public CarPostStoreClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<CarPostDto> carForSaleClient() {
        var responseEntity = restTemplate.getForEntity(POST_STORE_SERVICE_URI + "/cars", CarPostDto[].class);
        return Arrays.asList(Objects.requireNonNull(responseEntity.getBody()));
    }

    public void ownerPostClient(OwnerPostDto newUser) {
        restTemplate.postForEntity(USER_STORE_SERVICE_URI, newUser, OwnerPostDto.class);
    }

    public void changeCarForSaleClient(CarPostDto carPostDto, String id) {
        restTemplate.put(POST_STORE_SERVICE_URI + "/car/" + id, carPostDto, CarPostDto.class);
    }

    public void deleteCarForSaleClient(String id) {
        restTemplate.delete(POST_STORE_SERVICE_URI + "/car/" + id);
    }

}
