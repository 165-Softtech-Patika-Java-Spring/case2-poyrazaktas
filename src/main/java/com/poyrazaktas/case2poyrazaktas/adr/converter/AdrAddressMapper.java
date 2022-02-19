package com.poyrazaktas.case2poyrazaktas.adr.converter;

import com.poyrazaktas.case2poyrazaktas.adr.dto.AdrAddressDto;
import com.poyrazaktas.case2poyrazaktas.adr.dto.AdrAddressPostReqDto;
import com.poyrazaktas.case2poyrazaktas.adr.dto.AdrAddressUpdateReqDto;
import com.poyrazaktas.case2poyrazaktas.adr.entity.AdrAddress;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AdrAddressMapper {
    AdrAddressMapper INSTANCE = Mappers.getMapper(AdrAddressMapper.class);

    AdrAddress convertToAddress(AdrAddressPostReqDto addressPostReqDto);

    AdrAddress convertToAddress(AdrAddressUpdateReqDto addressUpdateReqDto);

    AdrAddressDto convertToAddressDto(AdrAddress address);

    List<AdrAddressDto> convertToAddressDtoList(List<AdrAddress> addressList);
}
