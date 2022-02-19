package com.poyrazaktas.case2poyrazaktas.adr.dao;

import com.poyrazaktas.case2poyrazaktas.adr.entity.AdrAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdrAddressDao extends JpaRepository<AdrAddress, Long> {
}
