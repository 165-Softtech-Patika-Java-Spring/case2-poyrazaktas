package com.poyrazaktas.case2poyrazaktas.cnt.converter;

import com.poyrazaktas.case2poyrazaktas.cnt.dto.CntCountryDto;
import com.poyrazaktas.case2poyrazaktas.cnt.dto.CntCountryPostReqDto;
import com.poyrazaktas.case2poyrazaktas.cnt.dto.CntCountryUpdateReqDto;
import com.poyrazaktas.case2poyrazaktas.cnt.entity.CntCountry;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CntCountryMapper {
    CntCountryMapper INSTANCE = Mappers.getMapper(CntCountryMapper.class);

    CntCountry convertToCountry(CntCountryPostReqDto countryPostReqDto);

    CntCountry convertToCountry(CntCountryUpdateReqDto countryUpdateReqDto);

    CntCountryDto convertToCountryDto(CntCountry country);

    List<CntCountryDto> convertToCountryDtoList(List<CntCountry> countryList);
}
