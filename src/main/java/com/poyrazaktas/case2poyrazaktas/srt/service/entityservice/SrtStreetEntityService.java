package com.poyrazaktas.case2poyrazaktas.srt.service.entityservice;

import com.poyrazaktas.case2poyrazaktas.srt.dao.SrtStreetDao;
import com.poyrazaktas.case2poyrazaktas.srt.entity.SrtStreet;
import com.poyrazaktas.case2poyrazaktas.exception.customexceptions.ItemNotFoundException;
import com.poyrazaktas.case2poyrazaktas.srt.util.enums.SrtStreetMessages;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SrtStreetEntityService {

    private final SrtStreetDao streetDao;

    public List<SrtStreet> findAll() {
        return streetDao.findAll();
    }

    public Optional<SrtStreet> findById(Long id) {
        return streetDao.findById(id);
    }

    public boolean existsById(Long id) {
        return streetDao.existsById(id);
    }

    public SrtStreet get(Long id) {
        SrtStreet street;
        if (existsById(id)){
            street = findById(id).get();
        }else{
            throw new ItemNotFoundException(SrtStreetMessages.NOT_FOUND.getMessage());
        }
        return street;
    }

    public SrtStreet save(SrtStreet entity) {
        return streetDao.save(entity);
    }

    public void delete(SrtStreet entity) {
        streetDao.delete(entity);
    }

}
