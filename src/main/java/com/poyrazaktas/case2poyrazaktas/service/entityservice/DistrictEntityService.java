package com.poyrazaktas.case2poyrazaktas.service.entityservice;

import com.poyrazaktas.case2poyrazaktas.dao.DistrictDao;
import com.poyrazaktas.case2poyrazaktas.entity.District;
import com.poyrazaktas.case2poyrazaktas.exception.customexceptions.ItemNotFoundException;
import com.poyrazaktas.case2poyrazaktas.util.DistrictMessages;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DistrictEntityService implements IEntityService<District>{

    private final DistrictDao districtDao;

    @Override
    public List<District> findAll() {
        return districtDao.findAll();
    }

    @Override
    public Optional<District> findById(Long id) {
        return districtDao.findById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return districtDao.existsById(id);
    }

    @Override
    public District get(Long id) {
        District district;
        if (existsById(id)){
            district = findById(id).get();
        }else{
            throw new ItemNotFoundException(DistrictMessages.NOT_FOUND.getMessage());
        }
        return district;
    }

    @Override
    public District save(District entity) {
        return districtDao.save(entity);
    }

    @Override
    public void delete(District entity) {
        districtDao.delete(entity);
    }
}
