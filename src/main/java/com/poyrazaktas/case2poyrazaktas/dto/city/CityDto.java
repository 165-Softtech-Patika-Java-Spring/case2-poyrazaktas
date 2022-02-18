package com.poyrazaktas.case2poyrazaktas.dto.city;

import com.poyrazaktas.case2poyrazaktas.entity.Country;
import com.poyrazaktas.case2poyrazaktas.entity.District;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class CityDto {
    private String name;

    private int licensePlate;

    private List<District> districtList = new ArrayList<>();

    private Country country;

}
