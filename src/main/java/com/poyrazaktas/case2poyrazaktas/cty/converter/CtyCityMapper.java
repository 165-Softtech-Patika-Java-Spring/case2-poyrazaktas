package com.poyrazaktas.case2poyrazaktas.cty.converter;

import com.poyrazaktas.case2poyrazaktas.cty.dto.CtyCityDto;
import com.poyrazaktas.case2poyrazaktas.cty.dto.CtyCityPostReqDto;
import com.poyrazaktas.case2poyrazaktas.cty.dto.CtyCityUpdateReqDto;
import com.poyrazaktas.case2poyrazaktas.cty.entity.CtyCity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CtyCityMapper {
    CtyCityMapper INSTANCE = Mappers.getMapper(CtyCityMapper.class);

    CtyCity convertToCity(CtyCityPostReqDto cityPostReqDto);

    CtyCity convertToCity(CtyCityUpdateReqDto cityUpdateReqDto);

    CtyCityDto convertToCityDto(CtyCity city);

    List<CtyCityDto> convertToCityDtoList(List<CtyCity> cityList);

}
