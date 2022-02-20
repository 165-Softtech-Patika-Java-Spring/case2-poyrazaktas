package com.poyrazaktas.case2poyrazaktas.cty.controller;

import com.poyrazaktas.case2poyrazaktas.cty.dto.CtyCityDto;
import com.poyrazaktas.case2poyrazaktas.cty.dto.CtyCityPostReqDto;
import com.poyrazaktas.case2poyrazaktas.cty.dto.CtyCityUpdateReqDto;
import com.poyrazaktas.case2poyrazaktas.cty.service.CtyCityService;
import com.poyrazaktas.case2poyrazaktas.cty.util.enums.CtyCityMessages;
import com.poyrazaktas.case2poyrazaktas.exception.customexceptions.ItemNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/cities")
public class CtyCityController {
    private final CtyCityService cityService;

    @GetMapping("/findAll")
    public ResponseEntity findAll() {
        return ResponseEntity.ok(cityService.findAll());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity get(@PathVariable Long id) {
        CtyCityDto cityDto = cityService.get(id);
        return ResponseEntity.ok(cityDto);
    }

    @GetMapping("/getByLicensePlate/{licensePlate}")
    public ResponseEntity getByLicensePlate(@PathVariable int licensePlate) {
        List<CtyCityDto> cityDtoList = cityService.findAll();
        CtyCityDto cityDto = null;
        if (cityDtoList.size() == 0) {
            throw new ItemNotFoundException(CtyCityMessages.NOT_FOUND.getMessage());
        }
        for (CtyCityDto city :
                cityDtoList) {
            if (city.getLicensePlate() == licensePlate) {
                cityDto = city;
            }
        }
        if (cityDto == null) {
            throw new ItemNotFoundException(CtyCityMessages.NOT_FOUND.getMessage());
        }
        return ResponseEntity.ok(cityDto);
    }

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody CtyCityPostReqDto cityPostReqDto) {
        CtyCityDto cityDto = cityService.save(cityPostReqDto);
        return ResponseEntity.ok(cityDto);
    }

    @PutMapping("/update")
    public ResponseEntity update(@RequestBody CtyCityUpdateReqDto cityUpdateReqDto) {
        CtyCityDto cityDto = cityService.update(cityUpdateReqDto);
        return ResponseEntity.ok(cityDto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        cityService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
