package com.poyrazaktas.case2poyrazaktas.cty.dto;

import lombok.Data;

@Data
public class CtyCityUpdateReqDto {
    private Long id;
    private String name;
    private int licensePlate;
    private Long countryId;
}