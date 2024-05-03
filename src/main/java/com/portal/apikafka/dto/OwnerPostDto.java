package com.portal.apikafka.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude
public class OwnerPostDto {

    private String name;
    private String type;
    private String contactNumber;
}
