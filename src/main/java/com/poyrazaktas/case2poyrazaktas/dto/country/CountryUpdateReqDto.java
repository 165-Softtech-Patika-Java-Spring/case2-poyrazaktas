package com.poyrazaktas.case2poyrazaktas.dto.country;

import lombok.Data;

@Data
public class CountryUpdateReqDto {
    private Long id;
    private String name;
    private int countryCode;
}
