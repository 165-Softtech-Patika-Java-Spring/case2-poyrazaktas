package com.poyrazaktas.case2poyrazaktas.cnt.service.entityservice;

import com.poyrazaktas.case2poyrazaktas.cnt.dao.CntCountryDao;
import com.poyrazaktas.case2poyrazaktas.cnt.entity.CntCountry;
import com.poyrazaktas.case2poyrazaktas.exception.customexceptions.ItemNotFoundException;
import com.poyrazaktas.case2poyrazaktas.cnt.util.enums.CntCountryMessages;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CntCountryEntityService {

    private final CntCountryDao countryDao;

    public List<CntCountry> findAll() {
        return countryDao.findAll();
    }

    public CntCountry get(Long id) {
        return countryDao.findById(id).orElseThrow(() -> new ItemNotFoundException(CntCountryMessages.NOT_FOUND.getMessage()));
    }

    public CntCountry save(CntCountry entity) {
        return countryDao.save(entity);
    }

    public void delete(CntCountry entity) {
        countryDao.delete(entity);
    }
}
