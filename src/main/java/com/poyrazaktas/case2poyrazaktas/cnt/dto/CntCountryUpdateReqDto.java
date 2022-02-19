package com.poyrazaktas.case2poyrazaktas.cnt.dto;

import lombok.Data;

@Data
public class CntCountryUpdateReqDto {
    private Long id;
    private String name;
    private int countryCode;
}
