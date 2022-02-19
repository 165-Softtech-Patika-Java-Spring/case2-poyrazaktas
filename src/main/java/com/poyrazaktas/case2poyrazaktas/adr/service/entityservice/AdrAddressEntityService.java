package com.poyrazaktas.case2poyrazaktas.adr.service.entityservice;

import com.poyrazaktas.case2poyrazaktas.adr.dao.AdrAddressDao;
import com.poyrazaktas.case2poyrazaktas.adr.entity.AdrAddress;
import com.poyrazaktas.case2poyrazaktas.exception.customexceptions.ItemNotFoundException;
import com.poyrazaktas.case2poyrazaktas.adr.util.enums.AdrAddressMessages;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdrAddressEntityService {

    private final AdrAddressDao addressDao;

    public List<AdrAddress> findAll() {
        return addressDao.findAll();
    }

    public Optional<AdrAddress> findById(Long id) {
        return addressDao.findById(id);
    }

    public boolean existsById(Long id) {
        return addressDao.existsById(id);
    }

    public AdrAddress get(Long id) {
        AdrAddress address;
        if (existsById(id)) {
            address = findById(id).get();
        } else {
            throw new ItemNotFoundException(AdrAddressMessages.NOT_FOUND.getMessage());
        }
        return address;
    }

    public AdrAddress save(AdrAddress entity) {
        return addressDao.save(entity);
    }

    public void delete(AdrAddress entity) {
        addressDao.delete(entity);
    }
}
