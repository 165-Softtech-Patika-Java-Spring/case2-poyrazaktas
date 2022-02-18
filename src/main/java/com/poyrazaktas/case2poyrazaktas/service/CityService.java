package com.poyrazaktas.case2poyrazaktas.service;

import com.poyrazaktas.case2poyrazaktas.converter.CityMapper;
import com.poyrazaktas.case2poyrazaktas.dto.city.CityDto;
import com.poyrazaktas.case2poyrazaktas.dto.city.CityPostReqDto;
import com.poyrazaktas.case2poyrazaktas.dto.city.CityUpdateReqDto;
import com.poyrazaktas.case2poyrazaktas.entity.City;
import com.poyrazaktas.case2poyrazaktas.entity.Country;
import com.poyrazaktas.case2poyrazaktas.service.entityservice.CityEntityService;
import com.poyrazaktas.case2poyrazaktas.service.entityservice.CountryEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityService {
    private final CityEntityService cityEntityService;
    private final CountryEntityService countryEntityService;

    public List<CityDto> findAll(){
        List<City> cityList = cityEntityService.findAll();
        List<CityDto> cityDtoList = CityMapper.INSTANCE.convertToCityDtoList(cityList);
        return cityDtoList;
    }

    public CityDto save(CityPostReqDto cityPostReqDto){
        City city = CityMapper.INSTANCE.convertToCity(cityPostReqDto);
        Country country = countryEntityService.get(cityPostReqDto.getCountryId());
        city.setCountry(country);
        city = cityEntityService.save(city);
        CityDto cityDto = CityMapper.INSTANCE.convertToCityDto(city);
        return cityDto;
    }

    public CityDto get(Long id){
        City city = cityEntityService.get(id);
        CityDto cityDto = CityMapper.INSTANCE.convertToCityDto(city);
        return cityDto;
    }

    public CityDto update(CityUpdateReqDto cityUpdateReqDto){
        City city = CityMapper.INSTANCE.convertToCity(cityUpdateReqDto);
        checkIfCityExists(city);
        city = cityEntityService.save(city);
        CityDto cityDto = CityMapper.INSTANCE.convertToCityDto(city);
        return cityDto;
    }

    public void delete(Long id){
        City city = cityEntityService.get(id);
        cityEntityService.delete(city);
    }

    private void checkIfCityExists(City city){
        // if country exists it will not throw an error
        cityEntityService.existsById(city.getId());
    }
}
