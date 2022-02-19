package com.poyrazaktas.case2poyrazaktas.srt.converter;

import com.poyrazaktas.case2poyrazaktas.srt.dto.SrtStreetDto;
import com.poyrazaktas.case2poyrazaktas.srt.dto.SrtStreetPostReqDto;
import com.poyrazaktas.case2poyrazaktas.srt.dto.SrtStreetUpdateDto;
import com.poyrazaktas.case2poyrazaktas.srt.entity.SrtStreet;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SrtStreetMapper {
    SrtStreetMapper INSTANCE = Mappers.getMapper(SrtStreetMapper.class);

    SrtStreet convertToStreet(SrtStreetPostReqDto streetPostReqDto);

    SrtStreet convertToStreet(SrtStreetUpdateDto streetUpdateDto);

    SrtStreetDto convertToStreetDto(SrtStreet street);

    List<SrtStreetDto> convertToStreetDtoList(List<SrtStreet> streetList);
}
