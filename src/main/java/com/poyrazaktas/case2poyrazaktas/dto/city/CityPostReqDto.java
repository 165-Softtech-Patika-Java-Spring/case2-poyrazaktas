package com.poyrazaktas.case2poyrazaktas.dto.city;

import lombok.Data;

@Data
public class CityPostReqDto {
    private String name;
    private int licensePlate;
    private Long countryId;
}
