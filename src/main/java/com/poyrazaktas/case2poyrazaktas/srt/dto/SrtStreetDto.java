package com.poyrazaktas.case2poyrazaktas.srt.dto;

import com.poyrazaktas.case2poyrazaktas.ngh.entity.NghNeighborhood;
import lombok.Data;

@Data
public class SrtStreetDto {
    private String name;
    private NghNeighborhood neighborhood;
}
