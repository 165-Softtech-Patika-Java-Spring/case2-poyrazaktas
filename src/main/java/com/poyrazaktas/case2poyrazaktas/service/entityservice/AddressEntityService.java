package com.poyrazaktas.case2poyrazaktas.service.entityservice;

import com.poyrazaktas.case2poyrazaktas.dao.AddressDao;
import com.poyrazaktas.case2poyrazaktas.entity.Address;
import com.poyrazaktas.case2poyrazaktas.exception.customexceptions.ItemNotFoundException;
import com.poyrazaktas.case2poyrazaktas.util.AddressMessages;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddressEntityService implements IEntityServiceManager<Address> {

    private final AddressDao addressDao;

    @Override
    public List<Address> findAll() {
        return addressDao.findAll();
    }

    @Override
    public Optional<Address> findById(Long id) {
        return addressDao.findById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return addressDao.existsById(id);
    }

    @Override
    public Address get(Long id) {
        Address address;
        if (existsById(id)) {
            address = findById(id).get();
        } else {
            throw new ItemNotFoundException(AddressMessages.NOT_FOUND.getMessage());
        }
        return address;
    }

    @Override
    public Address save(Address entity) {
        return addressDao.save(entity);
    }

    @Override
    public void delete(Address entity) {
        addressDao.delete(entity);
    }
}
