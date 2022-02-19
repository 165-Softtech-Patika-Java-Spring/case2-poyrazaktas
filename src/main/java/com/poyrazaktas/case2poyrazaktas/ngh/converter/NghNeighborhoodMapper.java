package com.poyrazaktas.case2poyrazaktas.ngh.converter;

import com.poyrazaktas.case2poyrazaktas.ngh.dto.NghNeighborhoodDto;
import com.poyrazaktas.case2poyrazaktas.ngh.dto.NghNeighborhoodPostReqDto;
import com.poyrazaktas.case2poyrazaktas.ngh.dto.NghNeighborhoodUpdateReqDto;
import com.poyrazaktas.case2poyrazaktas.ngh.entity.NghNeighborhood;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface NghNeighborhoodMapper {
    NghNeighborhoodMapper INSTANCE = Mappers.getMapper(NghNeighborhoodMapper.class);

    NghNeighborhood convertToNeighborhood(NghNeighborhoodPostReqDto neighborhoodPostReqDto);

    NghNeighborhood convertToNeighborhood(NghNeighborhoodUpdateReqDto neighborhoodUpdateReqDto);

    NghNeighborhoodDto convertToNeighborhoodDto(NghNeighborhood neighborhood);

    List<NghNeighborhoodDto> convertToNeighborhoodDtoList(List<NghNeighborhood> neighborhoodList);


}
