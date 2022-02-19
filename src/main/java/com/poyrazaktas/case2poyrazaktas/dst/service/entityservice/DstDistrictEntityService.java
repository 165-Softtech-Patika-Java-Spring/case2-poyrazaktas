package com.poyrazaktas.case2poyrazaktas.dst.service.entityservice;

import com.poyrazaktas.case2poyrazaktas.dst.dao.DstDistrictDao;
import com.poyrazaktas.case2poyrazaktas.dst.entity.DstDistrict;
import com.poyrazaktas.case2poyrazaktas.dst.util.enums.DstDistrictMessages;
import com.poyrazaktas.case2poyrazaktas.exception.customexceptions.ItemNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DstDistrictEntityService {

    private final DstDistrictDao districtDao;

    public List<DstDistrict> findAll() {
        return districtDao.findAll();
    }

    public DstDistrict get(Long id) {
        return districtDao.findById(id).orElseThrow(() -> new ItemNotFoundException(DstDistrictMessages.NOT_FOUND.getMessage()));
    }

    public DstDistrict save(DstDistrict entity) {
        return districtDao.save(entity);
    }

    public void delete(DstDistrict entity) {
        districtDao.delete(entity);
    }
}
