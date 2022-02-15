package com.poyrazaktas.case2poyrazaktas.dao;

import com.poyrazaktas.case2poyrazaktas.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryDao extends JpaRepository<Country, Long> {
}
