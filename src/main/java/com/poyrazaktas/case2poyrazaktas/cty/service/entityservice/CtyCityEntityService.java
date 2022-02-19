package com.poyrazaktas.case2poyrazaktas.cty.service.entityservice;

import com.poyrazaktas.case2poyrazaktas.cty.dao.CtyCityDao;
import com.poyrazaktas.case2poyrazaktas.cty.entity.CtyCity;
import com.poyrazaktas.case2poyrazaktas.exception.customexceptions.ItemNotFoundException;
import com.poyrazaktas.case2poyrazaktas.cty.util.enums.CtyCityMessages;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class CtyCityEntityService {

    private final CtyCityDao cityDao;

    public List<CtyCity> findAll() {
        return cityDao.findAll();
    }

    public Optional<CtyCity> findById(Long id) {
        return cityDao.findById(id);
    }

    public boolean existsById(Long id) {
        return cityDao.existsById(id);
    }

    public CtyCity get(Long id) {

        CtyCity city;
        if (existsById(id)){
            city = findById(id).get();
        }else{
            throw new ItemNotFoundException(CtyCityMessages.NOT_FOUND.getMessage());
        }

        return city;
    }

    public CtyCity save(CtyCity entity) {
        return cityDao.save(entity);
    }

    public void delete(CtyCity entity) {
        cityDao.delete(entity);
    }
}
