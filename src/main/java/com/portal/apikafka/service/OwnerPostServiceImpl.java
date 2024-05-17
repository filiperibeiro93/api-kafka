package com.portal.apikafka.service;

import com.portal.apikafka.client.CarPostStoreClient;
import com.portal.apikafka.dto.OwnerPostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnerPostServiceImpl implements OwnerPostService {

    private final CarPostStoreClient carPostStoreClient;

    @Autowired
    public OwnerPostServiceImpl(CarPostStoreClient carPostStoreClient) {
        this.carPostStoreClient = carPostStoreClient;
    }

    @Override
    public void createOwnerCar(OwnerPostDto dto) {
        carPostStoreClient.ownerPostClient(dto);
    }
}
