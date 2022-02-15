package com.poyrazaktas.case2poyrazaktas.service.entityservice;

import com.poyrazaktas.case2poyrazaktas.dao.NeighborhoodDao;
import com.poyrazaktas.case2poyrazaktas.entity.Neighborhood;
import com.poyrazaktas.case2poyrazaktas.exception.customexceptions.ItemNotFoundException;
import com.poyrazaktas.case2poyrazaktas.util.NeighborhoodMessages;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NeighborhoodEntityService implements IEntityService<Neighborhood> {

    private final NeighborhoodDao neighborhoodDao;

    @Override
    public List<Neighborhood> findAll() {
        return neighborhoodDao.findAll();
    }

    @Override
    public Optional<Neighborhood> findById(Long id) {
        return neighborhoodDao.findById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return neighborhoodDao.existsById(id);
    }

    @Override
    public Neighborhood get(Long id) {

        Neighborhood neighborhood;
        if (existsById(id)){
            neighborhood = findById(id).get();
        }else{
            throw new ItemNotFoundException(NeighborhoodMessages.NOT_FOUND.getMessage());
        }
        return neighborhood;
    }

    @Override
    public Neighborhood save(Neighborhood entity) {
        return neighborhoodDao.save(entity);
    }

    @Override
    public void delete(Neighborhood entity) {
        neighborhoodDao.delete(entity);
    }


}
