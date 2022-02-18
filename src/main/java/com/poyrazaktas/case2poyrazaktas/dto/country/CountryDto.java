package com.poyrazaktas.case2poyrazaktas.dto.country;

import com.poyrazaktas.case2poyrazaktas.entity.Address;
import com.poyrazaktas.case2poyrazaktas.entity.City;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CountryDto {
    private String name;

    private int countryCode;

    private List<City> cityList = new ArrayList<>();

}
