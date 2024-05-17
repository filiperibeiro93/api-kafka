package com.portal.apikafka.controller;

import com.portal.apikafka.dto.CarPostDto;
import com.portal.apikafka.message.KafkaProducerMessage;
import com.portal.apikafka.service.CarPostStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/car")
public class CarPostController {

    private final CarPostStoreService carPostStoreService;
    private final KafkaProducerMessage kafkaProducerMessage;

    @Autowired
    public CarPostController(CarPostStoreService carPostStoreService, KafkaProducerMessage kafkaProducerMessage) {
        this.carPostStoreService = carPostStoreService;
        this.kafkaProducerMessage = kafkaProducerMessage;
    }

    @GetMapping("/post")
    public ResponseEntity postCarForSale(@RequestBody CarPostDto dto) {
        kafkaProducerMessage.sendMessage(dto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/posts")
    public ResponseEntity<List<CarPostDto>> getCarSales() {
        return ResponseEntity.status(HttpStatus.FOUND).body(carPostStoreService.getCarsForSale());
    }

    @PutMapping("/{id}")
    public ResponseEntity changeCarForSale(@RequestBody CarPostDto carPostDto, @PathVariable("id") String id) {
        carPostStoreService.changeCarForSale(carPostDto, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCarForSale(@PathVariable("id") String id) {
        carPostStoreService.removeCarForSale(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
