package com.poyrazaktas.case2poyrazaktas.cnt.controller;

import com.poyrazaktas.case2poyrazaktas.cnt.dto.CntCountryDto;
import com.poyrazaktas.case2poyrazaktas.cnt.dto.CntCountryPostReqDto;
import com.poyrazaktas.case2poyrazaktas.cnt.dto.CntCountryUpdateReqDto;
import com.poyrazaktas.case2poyrazaktas.cnt.service.CntCountryService;
import com.poyrazaktas.case2poyrazaktas.cnt.util.enums.CntCountryMessages;
import com.poyrazaktas.case2poyrazaktas.exception.customexceptions.ItemNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/countries")
public class CntCountryController {
    private final CntCountryService countryService;

    @GetMapping("/findAll")
    public ResponseEntity findAll() {
        return ResponseEntity.ok(countryService.findAll());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity get(@PathVariable Long id) {
        return ResponseEntity.ok(countryService.get(id));
    }

    @GetMapping("/getByCountryCode/{countryCode}")
    public ResponseEntity getByCountryCode(@PathVariable int countryCode) {
        List<CntCountryDto> countryDtoList = countryService.findAll();
        CntCountryDto countryDto = null;

        if (countryDtoList.size() == 0) {
            throw new ItemNotFoundException(CntCountryMessages.NOT_FOUND.getMessage());
        }
        for (CntCountryDto country :
                countryDtoList) {
            if (country.getCountryCode() == countryCode) {
                countryDto = country;
                break;
            }
        }
        if (countryDto == null) {
            throw new ItemNotFoundException(CntCountryMessages.NOT_FOUND.getMessage());
        }

        return ResponseEntity.ok(countryDto);
    }

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody CntCountryPostReqDto entity) {
        CntCountryDto countryDto = countryService.save(entity);
        return ResponseEntity.ok(countryDto);
    }

    @PutMapping("/update")
    public ResponseEntity update(@RequestBody CntCountryUpdateReqDto entity) {
        CntCountryDto countryDto = countryService.update(entity);
        return ResponseEntity.ok(countryDto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        countryService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
