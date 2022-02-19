package com.poyrazaktas.case2poyrazaktas.cty.service.entityservice;

import com.poyrazaktas.case2poyrazaktas.cty.dao.CtyCityDao;
import com.poyrazaktas.case2poyrazaktas.cty.entity.CtyCity;
import com.poyrazaktas.case2poyrazaktas.cty.util.enums.CtyCityMessages;
import com.poyrazaktas.case2poyrazaktas.exception.customexceptions.ItemNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CtyCityEntityService {

    private final CtyCityDao cityDao;

    public List<CtyCity> findAll() {
        return cityDao.findAll();
    }

    public CtyCity get(Long id) {
        return cityDao.findById(id).orElseThrow(() -> new ItemNotFoundException(CtyCityMessages.NOT_FOUND.getMessage()));
    }

    public CtyCity save(CtyCity entity) {
        return cityDao.save(entity);
    }

    public void delete(CtyCity entity) {
        cityDao.delete(entity);
    }
}
