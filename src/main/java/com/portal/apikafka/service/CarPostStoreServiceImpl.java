package com.portal.apikafka.service;

import com.portal.apikafka.client.CarPostStoreClient;
import com.portal.apikafka.dto.CarPostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarPostStoreServiceImpl implements CarPostStoreService {

    private final CarPostStoreClient carPostStoreClient;

    @Autowired
    public CarPostStoreServiceImpl(CarPostStoreClient carPostStoreClient) {
        this.carPostStoreClient = carPostStoreClient;
    }

    @Override
    public List<CarPostDto> getCarsForSale() {
        return carPostStoreClient.carForSaleClient();
    }

    @Override
    public void changeCarForSale(CarPostDto dto, String id) {
        carPostStoreClient.changeCarForSaleClient(dto, id);
    }

    @Override
    public void removeCarForSale(String id) {
        carPostStoreClient.deleteCarForSaleClient(id);
    }
}
