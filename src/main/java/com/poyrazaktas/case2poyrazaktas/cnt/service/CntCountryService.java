package com.poyrazaktas.case2poyrazaktas.cnt.service;

import com.poyrazaktas.case2poyrazaktas.cnt.converter.CntCountryMapper;
import com.poyrazaktas.case2poyrazaktas.cnt.dto.CntCountryDto;
import com.poyrazaktas.case2poyrazaktas.cnt.dto.CntCountryPostReqDto;
import com.poyrazaktas.case2poyrazaktas.cnt.dto.CntCountryUpdateReqDto;
import com.poyrazaktas.case2poyrazaktas.cnt.entity.CntCountry;
import com.poyrazaktas.case2poyrazaktas.cnt.service.entityservice.CntCountryEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CntCountryService {

    private final CntCountryEntityService countryEntityService;

    public List<CntCountryDto> findAll() {
        List<CntCountry> countryList = countryEntityService.findAll();
        List<CntCountryDto> countryDtoList = CntCountryMapper.INSTANCE.convertToCountryDtoList(countryList);

        return countryDtoList;
    }

    public CntCountryDto save(CntCountryPostReqDto countryPostReqDto) {
        CntCountry country = CntCountryMapper.INSTANCE.convertToCountry(countryPostReqDto);
        country = countryEntityService.save(country);
        CntCountryDto countryDto = CntCountryMapper.INSTANCE.convertToCountryDto(country);
        return countryDto;
    }

    public CntCountryDto get(Long id) {
        CntCountry country = countryEntityService.get(id);
        CntCountryDto countryDto = CntCountryMapper.INSTANCE.convertToCountryDto(country);
        return countryDto;
    }

    public CntCountryDto update(CntCountryUpdateReqDto entity) {
        CntCountry country = CntCountryMapper.INSTANCE.convertToCountry(entity);
        checkIfCountryExists(country);
        country = countryEntityService.save(country);
        CntCountryDto countryDto = CntCountryMapper.INSTANCE.convertToCountryDto(country);
        return countryDto;
    }

    public void delete(Long id) {
        CntCountry country = countryEntityService.get(id);
        countryEntityService.delete(country);
    }

    private void checkIfCountryExists(CntCountry country) {
        // if country exists it will not throw an error
        countryEntityService.get(country.getId());
    }
}
