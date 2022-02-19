package com.poyrazaktas.case2poyrazaktas.srt.service;

import com.poyrazaktas.case2poyrazaktas.ngh.entity.NghNeighborhood;
import com.poyrazaktas.case2poyrazaktas.ngh.service.entityservice.NghNeighborhoodEntityService;
import com.poyrazaktas.case2poyrazaktas.srt.converter.SrtStreetMapper;
import com.poyrazaktas.case2poyrazaktas.srt.dto.SrtStreetDto;
import com.poyrazaktas.case2poyrazaktas.srt.dto.SrtStreetPostReqDto;
import com.poyrazaktas.case2poyrazaktas.srt.dto.SrtStreetUpdateDto;
import com.poyrazaktas.case2poyrazaktas.srt.entity.SrtStreet;
import com.poyrazaktas.case2poyrazaktas.srt.service.entityservice.SrtStreetEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SrtStreetService {
    private final SrtStreetEntityService streetEntityService;
    private final NghNeighborhoodEntityService neighborhoodEntityService;

    public List<SrtStreetDto> findAll(){
        List<SrtStreet> streetList = streetEntityService.findAll();
        List<SrtStreetDto> srtStreetDtoList = SrtStreetMapper.INSTANCE.convertToStreetDtoList(streetList);
        return srtStreetDtoList;
    }

    public SrtStreetDto get(Long id){
        SrtStreet street = streetEntityService.get(id);
        SrtStreetDto srtStreetDto = SrtStreetMapper.INSTANCE.convertToStreetDto(street);
        return srtStreetDto;
    }

    public SrtStreetDto save(SrtStreetPostReqDto streetPostReqDto){
        SrtStreet street = SrtStreetMapper.INSTANCE.convertToStreet(streetPostReqDto);
        NghNeighborhood neighborhood = neighborhoodEntityService.get(streetPostReqDto.getNeighborhoodId());
        street.setNeighborhood(neighborhood);
        street=streetEntityService.save(street);
        SrtStreetDto srtStreetDto = SrtStreetMapper.INSTANCE.convertToStreetDto(street);
        return srtStreetDto;
    }

    public SrtStreetDto update(SrtStreetUpdateDto streetUpdateDto){
        checkIfStreetExits(streetUpdateDto.getId());
        SrtStreet street = SrtStreetMapper.INSTANCE.convertToStreet(streetUpdateDto);
        NghNeighborhood neighborhood = neighborhoodEntityService.get(streetUpdateDto.getNeighborhoodId());
        street.setNeighborhood(neighborhood);
        street = streetEntityService.save(street);
        SrtStreetDto srtStreetDto = SrtStreetMapper.INSTANCE.convertToStreetDto(street);
        return srtStreetDto;
    }

    public void delete(Long id){
        SrtStreet street = streetEntityService.get(id);
        streetEntityService.delete(street);
    }

    private void checkIfStreetExits(Long id){
        streetEntityService.get(id);
    }
}
