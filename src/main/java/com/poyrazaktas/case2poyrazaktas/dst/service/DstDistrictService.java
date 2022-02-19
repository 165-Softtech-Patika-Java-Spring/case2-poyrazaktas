package com.poyrazaktas.case2poyrazaktas.dst.service;

import com.poyrazaktas.case2poyrazaktas.cty.entity.CtyCity;
import com.poyrazaktas.case2poyrazaktas.cty.service.entityservice.CtyCityEntityService;
import com.poyrazaktas.case2poyrazaktas.dst.converter.DstDistrictMapper;
import com.poyrazaktas.case2poyrazaktas.dst.dto.DstDistrictDto;
import com.poyrazaktas.case2poyrazaktas.dst.dto.DstDistrictPostReqDto;
import com.poyrazaktas.case2poyrazaktas.dst.dto.DstDistrictUpdateReqDto;
import com.poyrazaktas.case2poyrazaktas.dst.entity.DstDistrict;
import com.poyrazaktas.case2poyrazaktas.dst.service.entityservice.DstDistrictEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DstDistrictService {
    private final DstDistrictEntityService districtEntityService;
    private final CtyCityEntityService cityEntityService;

    public List<DstDistrictDto> findAll() {
        List<DstDistrict> districtList = districtEntityService.findAll();
        List<DstDistrictDto> districtDtoList = DstDistrictMapper.INSTANCE.convertToDistrictDtoList(districtList);
        return districtDtoList;
    }

    public DstDistrictDto get(Long id){
        DstDistrict district = districtEntityService.get(id);
        DstDistrictDto districtDto = DstDistrictMapper.INSTANCE.convertToDistrictDto(district);
        return districtDto;
    }

    public DstDistrictDto save(DstDistrictPostReqDto districtPostReqDto){
        DstDistrict district = DstDistrictMapper.INSTANCE.convertToDistrict(districtPostReqDto);
        CtyCity city = cityEntityService.get(districtPostReqDto.getCityId());
        district.setCity(city);
        district = districtEntityService.save(district);
        DstDistrictDto districtDto = DstDistrictMapper.INSTANCE.convertToDistrictDto(district);
        return districtDto;

    }

    public DstDistrictDto update(DstDistrictUpdateReqDto districtUpdateReqDto){
        checkIfDistrictExists(districtUpdateReqDto.getId());
        DstDistrict district = DstDistrictMapper.INSTANCE.convertToDistrict(districtUpdateReqDto);
        CtyCity city = cityEntityService.get(districtUpdateReqDto.getCityId());
        district.setCity(city);
        district = districtEntityService.save(district);

        DstDistrictDto districtDto = DstDistrictMapper.INSTANCE.convertToDistrictDto(district);

        return districtDto;

    }

    public void delete(Long id){
        DstDistrict district = districtEntityService.get(id);
        districtEntityService.delete(district);
    }

    private void checkIfDistrictExists(Long id){
        districtEntityService.get(id);
    }
}
