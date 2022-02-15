package com.poyrazaktas.case2poyrazaktas.controller;

import com.poyrazaktas.case2poyrazaktas.dao.CountryDao;
import com.poyrazaktas.case2poyrazaktas.entity.Country;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/countries")
public class CountryController implements IEntityController<Country>{
    private final CountryDao countryDao;

    @PostMapping
    public ResponseEntity save(@RequestBody Country entity) {
        Country save = countryDao.save(entity);
        return ResponseEntity.ok(save);
    }

    @Override
    public ResponseEntity update(Country entity) {
        return null;
    }

    @GetMapping
    public ResponseEntity findAll() {
        return ResponseEntity.ok(countryDao.findAll());
    }

    @Override
    public ResponseEntity findById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity delete() {
        return null;
    }

}
