package com.poyrazaktas.case2poyrazaktas.dao;

import com.poyrazaktas.case2poyrazaktas.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressDao extends JpaRepository<Address, Long> {
}
