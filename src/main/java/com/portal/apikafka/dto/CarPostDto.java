package com.portal.apikafka.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude
public class CarPostDto {

    private String model;
    private String brand;
    private Double price;
    private String description;
    private String engineVersion;
    private String city;
    private String createdAt;
    private Long ownerId;
    private String ownerName;
    private String ownerType;
    private String contact;
}
