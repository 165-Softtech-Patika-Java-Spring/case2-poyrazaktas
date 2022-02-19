package com.poyrazaktas.case2poyrazaktas.cnt.controller;

import com.poyrazaktas.case2poyrazaktas.cnt.dto.CntCountryDto;
import com.poyrazaktas.case2poyrazaktas.cnt.dto.CntCountryPostReqDto;
import com.poyrazaktas.case2poyrazaktas.cnt.dto.CntCountryUpdateReqDto;
import com.poyrazaktas.case2poyrazaktas.cnt.service.CntCountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/countries")
public class CntCountryController {
    private final CntCountryService countryService;

    @GetMapping
    public ResponseEntity findAll() {
        return ResponseEntity.ok(countryService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable Long id) {
        return ResponseEntity.ok(countryService.get(id));
    }

    @PostMapping
    public ResponseEntity save(@RequestBody CntCountryPostReqDto entity) {
        CntCountryDto countryDto = countryService.save(entity);
        return ResponseEntity.ok(countryDto);
    }

    @PutMapping
    public ResponseEntity update(@RequestBody CntCountryUpdateReqDto entity) {
        CntCountryDto countryDto = countryService.update(entity);
        return ResponseEntity.ok(countryDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        countryService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
