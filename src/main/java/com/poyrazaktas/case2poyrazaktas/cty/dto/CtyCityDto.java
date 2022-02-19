package com.poyrazaktas.case2poyrazaktas.cty.dto;

import com.poyrazaktas.case2poyrazaktas.cnt.entity.CntCountry;
import com.poyrazaktas.case2poyrazaktas.dst.entity.DstDistrict;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class CtyCityDto {
    private String name;

    private int licensePlate;

    private List<DstDistrict> districtList = new ArrayList<>();

    private CntCountry country;

}
