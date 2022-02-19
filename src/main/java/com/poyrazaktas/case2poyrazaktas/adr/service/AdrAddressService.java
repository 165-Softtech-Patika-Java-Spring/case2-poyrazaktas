package com.poyrazaktas.case2poyrazaktas.adr.service;

import com.poyrazaktas.case2poyrazaktas.adr.converter.AdrAddressMapper;
import com.poyrazaktas.case2poyrazaktas.adr.dto.AdrAddressDto;
import com.poyrazaktas.case2poyrazaktas.adr.dto.AdrAddressPostReqDto;
import com.poyrazaktas.case2poyrazaktas.adr.dto.AdrAddressUpdateReqDto;
import com.poyrazaktas.case2poyrazaktas.adr.entity.AdrAddress;
import com.poyrazaktas.case2poyrazaktas.adr.service.entityservice.AdrAddressEntityService;
import com.poyrazaktas.case2poyrazaktas.cnt.entity.CntCountry;
import com.poyrazaktas.case2poyrazaktas.cnt.service.entityservice.CntCountryEntityService;
import com.poyrazaktas.case2poyrazaktas.cty.entity.CtyCity;
import com.poyrazaktas.case2poyrazaktas.cty.service.entityservice.CtyCityEntityService;
import com.poyrazaktas.case2poyrazaktas.dst.entity.DstDistrict;
import com.poyrazaktas.case2poyrazaktas.dst.service.entityservice.DstDistrictEntityService;
import com.poyrazaktas.case2poyrazaktas.ngh.entity.NghNeighborhood;
import com.poyrazaktas.case2poyrazaktas.ngh.service.entityservice.NghNeighborhoodEntityService;
import com.poyrazaktas.case2poyrazaktas.srt.entity.SrtStreet;
import com.poyrazaktas.case2poyrazaktas.srt.service.entityservice.SrtStreetEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdrAddressService {
    private final AdrAddressEntityService addressEntityService;
    private final CntCountryEntityService countryEntityService;
    private final CtyCityEntityService cityEntityService;
    private final DstDistrictEntityService districtEntityService;
    private final NghNeighborhoodEntityService neighborhoodEntityService;
    private final SrtStreetEntityService streetEntityService;

    public List<AdrAddressDto> findAll(){
        List<AdrAddress> addressList = addressEntityService.findAll();
        List<AdrAddressDto> adrAddressDtoList = AdrAddressMapper.INSTANCE.convertToAddressDtoList(addressList);
        return adrAddressDtoList;
    }

    public AdrAddressDto get(Long id){
        AdrAddress address = addressEntityService.get(id);
        AdrAddressDto addressDto = AdrAddressMapper.INSTANCE.convertToAddressDto(address);
        return addressDto;
    }

    public AdrAddressDto save(AdrAddressPostReqDto addressPostReqDto){
        AdrAddress address = AdrAddressMapper.INSTANCE.convertToAddress(addressPostReqDto);
        SrtStreet street = streetEntityService.get(addressPostReqDto.getStreetId());
        NghNeighborhood neighborhood= street.getNeighborhood();
        DstDistrict district = neighborhood.getDistrict();
        CtyCity city = district.getCity();
        CntCountry country = city.getCountry();
        address.setCountry(country);
        address.setCity(city);
        address.setDistrict(district);
        address.setNeighborhood(neighborhood);
        address.setStreet(street);

        address = addressEntityService.save(address);

        AdrAddressDto addressDto = AdrAddressMapper.INSTANCE.convertToAddressDto(address);
        return addressDto;
    }

    public AdrAddressDto update(AdrAddressUpdateReqDto addressUpdateReqDto){

        checkIfAddressExists(addressUpdateReqDto.getId());

        AdrAddress address = AdrAddressMapper.INSTANCE.convertToAddress(addressUpdateReqDto);
        SrtStreet street = streetEntityService.get(addressUpdateReqDto.getStreetId());
        NghNeighborhood neighborhood= street.getNeighborhood();
        DstDistrict district = neighborhood.getDistrict();
        CtyCity city = district.getCity();
        CntCountry country = city.getCountry();
        address.setCountry(country);
        address.setCity(city);
        address.setDistrict(district);
        address.setNeighborhood(neighborhood);
        address.setStreet(street);

        address = addressEntityService.save(address);

        AdrAddressDto addressDto = AdrAddressMapper.INSTANCE.convertToAddressDto(address);
        return addressDto;
    }

    public void delete(Long id){
        AdrAddress address = addressEntityService.get(id);
        addressEntityService.delete(address);
    }

    private void checkIfAddressExists(Long id){
        addressEntityService.get(id);
    }
}
