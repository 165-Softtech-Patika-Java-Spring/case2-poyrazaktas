package com.poyrazaktas.case2poyrazaktas.ngh.service.entityservice;

import com.poyrazaktas.case2poyrazaktas.ngh.dao.NghNeighborhoodDao;
import com.poyrazaktas.case2poyrazaktas.ngh.entity.NghNeighborhood;
import com.poyrazaktas.case2poyrazaktas.exception.customexceptions.ItemNotFoundException;
import com.poyrazaktas.case2poyrazaktas.ngh.util.enums.NghNeighborhoodMessages;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NghNeighborhoodEntityService {

    private final NghNeighborhoodDao neighborhoodDao;

    public List<NghNeighborhood> findAll() {
        return neighborhoodDao.findAll();
    }

    public Optional<NghNeighborhood> findById(Long id) {
        return neighborhoodDao.findById(id);
    }

    public boolean existsById(Long id) {
        return neighborhoodDao.existsById(id);
    }

    public NghNeighborhood get(Long id) {

        NghNeighborhood neighborhood;
        if (existsById(id)) {
            neighborhood = findById(id).get();
        } else {
            throw new ItemNotFoundException(NghNeighborhoodMessages.NOT_FOUND.getMessage());
        }
        return neighborhood;
    }

    public NghNeighborhood save(NghNeighborhood entity) {
        return neighborhoodDao.save(entity);
    }

    public void delete(NghNeighborhood entity) {
        neighborhoodDao.delete(entity);
    }

}
