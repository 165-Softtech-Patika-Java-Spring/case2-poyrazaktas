package com.poyrazaktas.case2poyrazaktas.ngh.dto;

import com.poyrazaktas.case2poyrazaktas.dst.entity.DstDistrict;
import com.poyrazaktas.case2poyrazaktas.srt.entity.SrtStreet;
import lombok.Data;

import java.util.List;
@Data
public class NghNeighborhoodDto {
    private String name;
    private DstDistrict district;
    private List<SrtStreet> streetList;
}
