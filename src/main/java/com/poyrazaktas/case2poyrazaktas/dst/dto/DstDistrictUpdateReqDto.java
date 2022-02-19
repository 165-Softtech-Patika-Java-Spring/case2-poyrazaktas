package com.poyrazaktas.case2poyrazaktas.dst.dto;

import lombok.Data;

@Data
public class DstDistrictUpdateReqDto {
    Long id;
    String name;
    Long cityId;
}
