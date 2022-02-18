package com.poyrazaktas.case2poyrazaktas.service.entityservice;

import com.poyrazaktas.case2poyrazaktas.dao.StreetDao;
import com.poyrazaktas.case2poyrazaktas.entity.Street;
import com.poyrazaktas.case2poyrazaktas.exception.customexceptions.ItemNotFoundException;
import com.poyrazaktas.case2poyrazaktas.util.StreetMessages;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StreetEntityService implements IEntityServiceManager<Street> {

    private final StreetDao streetDao;

    @Override
    public List<Street> findAll() {
        return streetDao.findAll();
    }

    @Override
    public Optional<Street> findById(Long id) {
        return streetDao.findById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return streetDao.existsById(id);
    }

    @Override
    public Street get(Long id) {
        Street street;
        if (existsById(id)){
            street = findById(id).get();
        }else{
            throw new ItemNotFoundException(StreetMessages.NOT_FOUND.getMessage());
        }
        return street;
    }

    @Override
    public Street save(Street entity) {
        return streetDao.save(entity);
    }

    @Override
    public void delete(Street entity) {
        streetDao.delete(entity);
    }

}
