package com.poyrazaktas.case2poyrazaktas.service;

import com.poyrazaktas.case2poyrazaktas.converter.CountryMapper;
import com.poyrazaktas.case2poyrazaktas.dto.country.CountryDto;
import com.poyrazaktas.case2poyrazaktas.dto.country.CountryPostReqDto;
import com.poyrazaktas.case2poyrazaktas.dto.country.CountryUpdateReqDto;
import com.poyrazaktas.case2poyrazaktas.entity.Country;
import com.poyrazaktas.case2poyrazaktas.service.entityservice.CountryEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryService {

    private final CountryEntityService countryEntityService;

    public List<CountryDto> findAll() {
        List<Country> countryList = countryEntityService.findAll();
        List<CountryDto> countryDtoList = CountryMapper.INSTANCE.convertToCountryDtoList(countryList);

        return countryDtoList;
    }

    public CountryDto save(CountryPostReqDto countryPostReqDto) {
        Country country = CountryMapper.INSTANCE.convertToCountry(countryPostReqDto);
        country = countryEntityService.save(country);
        CountryDto countryDto = CountryMapper.INSTANCE.convertToCountryDto(country);
        return countryDto;
    }

    public CountryDto get(Long id) {
        Country country = countryEntityService.get(id);
        CountryDto countryDto = CountryMapper.INSTANCE.convertToCountryDto(country);
        return countryDto;
    }

    public CountryDto update(CountryUpdateReqDto entity) {
        Country country = CountryMapper.INSTANCE.convertToCountry(entity);
        checkIfCountryExists(country);
        country = countryEntityService.save(country);
        CountryDto countryDto = CountryMapper.INSTANCE.convertToCountryDto(country);
        return countryDto;
    }

    public void delete(Long id) {
        Country country = countryEntityService.get(id);
        countryEntityService.delete(country);
    }

    private void checkIfCountryExists(Country country) {
        // if country exists it will not throw an error
        countryEntityService.get(country.getId());
    }
}
