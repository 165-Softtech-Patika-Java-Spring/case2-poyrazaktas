package com.poyrazaktas.case2poyrazaktas.converter;

import com.poyrazaktas.case2poyrazaktas.dto.city.CityDto;
import com.poyrazaktas.case2poyrazaktas.dto.city.CityPostReqDto;
import com.poyrazaktas.case2poyrazaktas.dto.city.CityUpdateReqDto;
import com.poyrazaktas.case2poyrazaktas.entity.City;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CityMapper {
    CityMapper INSTANCE = Mappers.getMapper(CityMapper.class);

    City convertToCity(CityPostReqDto cityPostReqDto);

    City convertToCity(CityUpdateReqDto cityUpdateReqDto);

    CityDto convertToCityDto(City city);

    List<CityDto> convertToCityDtoList(List<City> cityList);

}
