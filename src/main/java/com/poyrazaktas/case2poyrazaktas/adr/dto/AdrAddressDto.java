package com.poyrazaktas.case2poyrazaktas.adr.dto;

import com.poyrazaktas.case2poyrazaktas.cnt.entity.CntCountry;
import com.poyrazaktas.case2poyrazaktas.cty.entity.CtyCity;
import com.poyrazaktas.case2poyrazaktas.dst.entity.DstDistrict;
import com.poyrazaktas.case2poyrazaktas.ngh.entity.NghNeighborhood;
import com.poyrazaktas.case2poyrazaktas.srt.entity.SrtStreet;
import lombok.Data;

@Data
public class AdrAddressDto {
    private CntCountry country;

    private CtyCity city;

    private DstDistrict district;

    private NghNeighborhood neighborhood;

    private SrtStreet street;

    private int gateNumber;
    private int apartmentNumber;
}
