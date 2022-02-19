package com.poyrazaktas.case2poyrazaktas.adr.service.entityservice;

import com.poyrazaktas.case2poyrazaktas.adr.dao.AdrAddressDao;
import com.poyrazaktas.case2poyrazaktas.adr.entity.AdrAddress;
import com.poyrazaktas.case2poyrazaktas.adr.util.enums.AdrAddressMessages;
import com.poyrazaktas.case2poyrazaktas.exception.customexceptions.ItemNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdrAddressEntityService {

    private final AdrAddressDao addressDao;

    public List<AdrAddress> findAll() {
        return addressDao.findAll();
    }

    public AdrAddress get(Long id) {
        return addressDao.findById(id).orElseThrow(() -> new ItemNotFoundException(AdrAddressMessages.NOT_FOUND.getMessage()));
    }

    public AdrAddress save(AdrAddress entity) {
        return addressDao.save(entity);
    }

    public void delete(AdrAddress entity) {
        addressDao.delete(entity);
    }
}
