package com.poyrazaktas.case2poyrazaktas.dao;

import com.poyrazaktas.case2poyrazaktas.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityDao extends JpaRepository<City, Long> {
}
