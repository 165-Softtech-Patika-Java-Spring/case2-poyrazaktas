package com.poyrazaktas.case2poyrazaktas.srt.dto;

import lombok.Data;

@Data
public class SrtStreetUpdateDto {
    private Long id;
    private String name;
    private Long neighborhoodId;
}
