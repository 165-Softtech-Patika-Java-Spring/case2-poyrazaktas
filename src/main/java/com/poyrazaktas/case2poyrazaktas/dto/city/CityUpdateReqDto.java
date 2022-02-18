package com.poyrazaktas.case2poyrazaktas.dto.city;

import lombok.Data;

@Data
public class CityUpdateReqDto {
    private Long id;
    private String name;
    private int licensePlate;
    private Long countryId;
}