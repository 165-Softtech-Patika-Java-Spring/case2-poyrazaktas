package com.poyrazaktas.case2poyrazaktas.adr.dto;

import lombok.Data;

@Data
public class AdrAddressPostReqDto {
    private Long streetId;
    private int gateNumber;
    private int apartmentNumber;
}
