package com.portal.apikafka.service;

import com.portal.apikafka.dto.CarPostDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarPostStoreServiceImpl implements CarPostStoreService {

    @Override
    public List<CarPostDto> getCarsForSale() {
        return null;
    }

    @Override
    public void changeCarForSale(CarPostDto dto, String id) {

    }

    @Override
    public void removeCarForSale(String id) {

    }
}
