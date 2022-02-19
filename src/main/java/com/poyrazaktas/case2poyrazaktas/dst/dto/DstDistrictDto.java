package com.poyrazaktas.case2poyrazaktas.dst.dto;

import com.poyrazaktas.case2poyrazaktas.cty.entity.CtyCity;
import com.poyrazaktas.case2poyrazaktas.ngh.entity.NghNeighborhood;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DstDistrictDto {
    String name;
    CtyCity city;
    List<NghNeighborhood> neighborhoodList=new ArrayList<>();
}
