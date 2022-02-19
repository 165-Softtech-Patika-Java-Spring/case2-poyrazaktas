package com.poyrazaktas.case2poyrazaktas.cnt.dto;

import com.poyrazaktas.case2poyrazaktas.cty.entity.CtyCity;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CntCountryDto {
    private String name;

    private int countryCode;

    private List<CtyCity> cityList = new ArrayList<>();

}
