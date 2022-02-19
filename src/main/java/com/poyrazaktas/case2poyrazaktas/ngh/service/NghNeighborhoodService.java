package com.poyrazaktas.case2poyrazaktas.ngh.service;

import com.poyrazaktas.case2poyrazaktas.dst.entity.DstDistrict;
import com.poyrazaktas.case2poyrazaktas.dst.service.entityservice.DstDistrictEntityService;
import com.poyrazaktas.case2poyrazaktas.ngh.converter.NghNeighborhoodMapper;
import com.poyrazaktas.case2poyrazaktas.ngh.dto.NghNeighborhoodDto;
import com.poyrazaktas.case2poyrazaktas.ngh.dto.NghNeighborhoodPostReqDto;
import com.poyrazaktas.case2poyrazaktas.ngh.dto.NghNeighborhoodUpdateReqDto;
import com.poyrazaktas.case2poyrazaktas.ngh.entity.NghNeighborhood;
import com.poyrazaktas.case2poyrazaktas.ngh.service.entityservice.NghNeighborhoodEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NghNeighborhoodService {
    private final NghNeighborhoodEntityService neighborhoodEntityService;
    private final DstDistrictEntityService districtEntityService;

    public List<NghNeighborhoodDto> findAll(){
        List<NghNeighborhood> neighborhoodList = neighborhoodEntityService.findAll();
        List<NghNeighborhoodDto> neighborhoodDtoList = NghNeighborhoodMapper.INSTANCE.convertToNeighborhoodDtoList(neighborhoodList);
        return neighborhoodDtoList;
    }

    public NghNeighborhoodDto get(Long id){
        NghNeighborhood neighborhood = neighborhoodEntityService.get(id);
        NghNeighborhoodDto neighborhoodDto = NghNeighborhoodMapper.INSTANCE.convertToNeighborhoodDto(neighborhood);
        return neighborhoodDto;
    }

    public NghNeighborhoodDto save(NghNeighborhoodPostReqDto neighborhoodPostReqDto){
        NghNeighborhood neighborhood = NghNeighborhoodMapper.INSTANCE.convertToNeighborhood(neighborhoodPostReqDto);
        DstDistrict district = districtEntityService.get(neighborhoodPostReqDto.getDistrictId());
        neighborhood.setDistrict(district);
        neighborhood = neighborhoodEntityService.save(neighborhood);
        NghNeighborhoodDto neighborhoodDto = NghNeighborhoodMapper.INSTANCE.convertToNeighborhoodDto(neighborhood);
        return neighborhoodDto;
    }

    public NghNeighborhoodDto update(NghNeighborhoodUpdateReqDto neighborhoodUpdateReqDto){
        checkIfNeighborhoodExists(neighborhoodUpdateReqDto.getId());
        NghNeighborhood neighborhood = NghNeighborhoodMapper.INSTANCE.convertToNeighborhood(neighborhoodUpdateReqDto);
        DstDistrict district = districtEntityService.get(neighborhoodUpdateReqDto.getDistrictId());
        neighborhood.setDistrict(district);
        neighborhood = neighborhoodEntityService.save(neighborhood);
        NghNeighborhoodDto neighborhoodDto = NghNeighborhoodMapper.INSTANCE.convertToNeighborhoodDto(neighborhood);
        return neighborhoodDto;
    }

    public void delete(Long id){
        NghNeighborhood neighborhood = neighborhoodEntityService.get(id);
        neighborhoodEntityService.delete(neighborhood);
    }

    private void checkIfNeighborhoodExists(Long id){
        neighborhoodEntityService.get(id);
    }
}
