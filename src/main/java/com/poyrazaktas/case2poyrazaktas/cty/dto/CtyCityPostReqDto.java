package com.poyrazaktas.case2poyrazaktas.cty.dto;

import lombok.Data;

@Data
public class CtyCityPostReqDto {
    private String name;
    private int licensePlate;
    private Long countryId;
}
