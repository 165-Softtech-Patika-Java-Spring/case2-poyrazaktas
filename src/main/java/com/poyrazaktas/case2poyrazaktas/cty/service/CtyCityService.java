package com.poyrazaktas.case2poyrazaktas.cty.service;

import com.poyrazaktas.case2poyrazaktas.cty.converter.CtyCityMapper;
import com.poyrazaktas.case2poyrazaktas.cty.dto.CtyCityDto;
import com.poyrazaktas.case2poyrazaktas.cty.dto.CtyCityPostReqDto;
import com.poyrazaktas.case2poyrazaktas.cty.dto.CtyCityUpdateReqDto;
import com.poyrazaktas.case2poyrazaktas.cty.entity.CtyCity;
import com.poyrazaktas.case2poyrazaktas.cnt.entity.CntCountry;
import com.poyrazaktas.case2poyrazaktas.cty.service.entityservice.CtyCityEntityService;
import com.poyrazaktas.case2poyrazaktas.cnt.service.entityservice.CntCountryEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CtyCityService {
    private final CtyCityEntityService cityEntityService;
    private final CntCountryEntityService countryEntityService;

    public List<CtyCityDto> findAll(){
        List<CtyCity> cityList = cityEntityService.findAll();
        List<CtyCityDto> cityDtoList = CtyCityMapper.INSTANCE.convertToCityDtoList(cityList);
        return cityDtoList;
    }

    public CtyCityDto save(CtyCityPostReqDto cityPostReqDto){
        CtyCity city = CtyCityMapper.INSTANCE.convertToCity(cityPostReqDto);
        CntCountry country = countryEntityService.get(cityPostReqDto.getCountryId());
        city.setCountry(country);
        city = cityEntityService.save(city);
        CtyCityDto cityDto = CtyCityMapper.INSTANCE.convertToCityDto(city);
        return cityDto;
    }

    public CtyCityDto get(Long id){
        CtyCity city = cityEntityService.get(id);
        CtyCityDto cityDto = CtyCityMapper.INSTANCE.convertToCityDto(city);
        return cityDto;
    }

    public CtyCityDto update(CtyCityUpdateReqDto cityUpdateReqDto){
        CtyCity city = CtyCityMapper.INSTANCE.convertToCity(cityUpdateReqDto);
        checkIfCityExists(city);
        CntCountry country = countryEntityService.get(cityUpdateReqDto.getCountryId());
        city.setCountry(country);
        city = cityEntityService.save(city);
        CtyCityDto cityDto = CtyCityMapper.INSTANCE.convertToCityDto(city);
        return cityDto;
    }

    public void delete(Long id){
        CtyCity city = cityEntityService.get(id);
        cityEntityService.delete(city);
    }

    private void checkIfCityExists(CtyCity city){
        // if country exists it will not throw an error
        cityEntityService.get(city.getId());
    }
}
