package com.portal.apikafka.message;

import com.portal.apikafka.dto.CarPostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducerMessage {

    private final KafkaTemplate<String, CarPostDto> kafkaTemplate;

    private final String KAFKA_TOPIC = "car-post-topic";

    @Autowired
    public KafkaProducerMessage(KafkaTemplate<String, CarPostDto> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(CarPostDto dto) {
        kafkaTemplate.send(KAFKA_TOPIC, dto);
    }

}
