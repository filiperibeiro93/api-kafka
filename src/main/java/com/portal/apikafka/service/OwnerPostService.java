package com.portal.apikafka.service;

import com.portal.apikafka.dto.OwnerPostDto;
import org.springframework.stereotype.Service;

@Service
public interface OwnerPostService {

    void createOwnerCar(OwnerPostDto dto);
}
