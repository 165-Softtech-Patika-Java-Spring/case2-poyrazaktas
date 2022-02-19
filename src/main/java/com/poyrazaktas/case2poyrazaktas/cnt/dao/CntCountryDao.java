package com.poyrazaktas.case2poyrazaktas.cnt.dao;

import com.poyrazaktas.case2poyrazaktas.cnt.entity.CntCountry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CntCountryDao extends JpaRepository<CntCountry, Long> {
}
