package com.portal.apikafka.service;

import com.portal.apikafka.dto.CarPostDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarPostStoreService {

    List<CarPostDto> getCarsForSale();

    void changeCarForSale(CarPostDto dto, String id);

    void removeCarForSale(String id);
}
