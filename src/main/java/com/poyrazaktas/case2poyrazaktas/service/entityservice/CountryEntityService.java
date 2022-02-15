package com.poyrazaktas.case2poyrazaktas.service.entityservice;

import com.poyrazaktas.case2poyrazaktas.dao.CountryDao;
import com.poyrazaktas.case2poyrazaktas.entity.Country;
import com.poyrazaktas.case2poyrazaktas.exception.customexceptions.ItemNotFoundException;
import com.poyrazaktas.case2poyrazaktas.util.CountryMessages;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CountryEntityService
        implements IEntityService<Country> {

    private final CountryDao countryDao;

    @Override
    public List<Country> findAll() {
        return countryDao.findAll();
    }

    @Override
    public Optional<Country> findById(Long id) {
        return countryDao.findById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return countryDao.existsById(id);
    }

    @Override
    public Country get(Long id) {
        Country country;
        if (existsById(id)) {
            country = findById(id).get();
        } else {
            throw new ItemNotFoundException(CountryMessages.NOT_FOUND.getMessage());
        }
        return country;
    }

    @Override
    public Country save(Country entity) {
        return countryDao.save(entity);
    }

    @Override
    public void delete(Country entity) {
        countryDao.delete(entity);
    }
}
