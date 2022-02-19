package com.poyrazaktas.case2poyrazaktas.dst.converter;

import com.poyrazaktas.case2poyrazaktas.dst.dto.DstDistrictDto;
import com.poyrazaktas.case2poyrazaktas.dst.dto.DstDistrictPostReqDto;
import com.poyrazaktas.case2poyrazaktas.dst.dto.DstDistrictUpdateReqDto;
import com.poyrazaktas.case2poyrazaktas.dst.entity.DstDistrict;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DstDistrictMapper {
    DstDistrictMapper INSTANCE = Mappers.getMapper(DstDistrictMapper.class);

    DstDistrict convertToDistrict(DstDistrictPostReqDto districtPostReqDto);

    DstDistrict convertToDistrict(DstDistrictUpdateReqDto districtUpdateReqDto);

    DstDistrictDto convertToDistrictDto(DstDistrict district);

    List<DstDistrictDto> convertToDistrictDtoList(List<DstDistrict> districtList);

}
