package com.poyrazaktas.case2poyrazaktas.adr.dto;

import lombok.Data;

@Data
public class AdrAddressUpdateReqDto {
    private Long id;

    private Long streetId;

    private int gateNumber;
    private int apartmentNumber;
}
