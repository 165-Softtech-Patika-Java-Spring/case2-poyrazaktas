package com.poyrazaktas.case2poyrazaktas.service.entityservice;

import com.poyrazaktas.case2poyrazaktas.dao.CityDao;
import com.poyrazaktas.case2poyrazaktas.entity.City;
import com.poyrazaktas.case2poyrazaktas.exception.customexceptions.ItemNotFoundException;
import com.poyrazaktas.case2poyrazaktas.util.CityMessages;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class CityEntityService implements IEntityService<City>{

    private final CityDao cityDao;

    @Override
    public List<City> findAll() {
        return cityDao.findAll();
    }

    @Override
    public Optional<City> findById(Long id) {
        return cityDao.findById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return cityDao.existsById(id);
    }

    @Override
    public City get(Long id) {

        City city;
        if (existsById(id)){
            city = findById(id).get();
        }else{
            throw new ItemNotFoundException(CityMessages.NOT_FOUND.getMessage());
        }

        return city;
    }

    @Override
    public City save(City entity) {
        return cityDao.save(entity);
    }

    @Override
    public void delete(City entity) {
        cityDao.delete(entity);
    }
}
