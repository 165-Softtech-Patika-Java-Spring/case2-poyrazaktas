package com.poyrazaktas.case2poyrazaktas.converter;

import com.poyrazaktas.case2poyrazaktas.dto.country.CountryDto;
import com.poyrazaktas.case2poyrazaktas.dto.country.CountryPostReqDto;
import com.poyrazaktas.case2poyrazaktas.dto.country.CountryUpdateReqDto;
import com.poyrazaktas.case2poyrazaktas.entity.Country;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CountryMapper {
    CountryMapper INSTANCE = Mappers.getMapper(CountryMapper.class);

    Country convertToCountry(CountryPostReqDto countryPostReqDto);

    Country convertToCountry(CountryUpdateReqDto countryUpdateReqDto);

    CountryDto convertToCountryDto(Country country);

    List<CountryDto> convertToCountryDtoList(List<Country> countryList);
}
