package com.poyrazaktas.case2poyrazaktas.controller;

import com.poyrazaktas.case2poyrazaktas.dto.country.CountryDto;
import com.poyrazaktas.case2poyrazaktas.dto.country.CountryPostReqDto;
import com.poyrazaktas.case2poyrazaktas.dto.country.CountryUpdateReqDto;
import com.poyrazaktas.case2poyrazaktas.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/countries")
public class CountryController {
    private final CountryService countryService;

    @GetMapping
    public ResponseEntity findAll() {
        return ResponseEntity.ok(countryService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable Long id) {
        return ResponseEntity.ok(countryService.get(id));
    }

    @PostMapping
    public ResponseEntity save(@RequestBody CountryPostReqDto entity) {
        CountryDto countryDto = countryService.save(entity);
        return ResponseEntity.ok(countryDto);
    }

    @PutMapping
    public ResponseEntity update(@RequestBody CountryUpdateReqDto entity) {
        CountryDto countryDto = countryService.update(entity);
        return ResponseEntity.ok(countryDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        countryService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
