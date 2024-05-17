package com.portal.apikafka.controller;

import com.portal.apikafka.dto.OwnerPostDto;
import com.portal.apikafka.service.OwnerPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/owner")
public class OwnerPostController {

    private final OwnerPostService ownerPostService;

    @Autowired
    public OwnerPostController(OwnerPostService ownerPostService) {
        this.ownerPostService = ownerPostService;
    }

    @PostMapping
    public ResponseEntity createOwnerCar(@RequestBody OwnerPostDto dto) {
        ownerPostService.createOwnerCar(dto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
