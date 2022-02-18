package com.poyrazaktas.case2poyrazaktas.controller;

import com.poyrazaktas.case2poyrazaktas.dto.city.CityDto;
import com.poyrazaktas.case2poyrazaktas.dto.city.CityPostReqDto;
import com.poyrazaktas.case2poyrazaktas.dto.city.CityUpdateReqDto;
import com.poyrazaktas.case2poyrazaktas.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/cities")
public class CityController{
    private final CityService cityService;

    @GetMapping
    public ResponseEntity findAll(){
        return ResponseEntity.ok(cityService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable Long id){
        CityDto cityDto = cityService.get(id);
        return ResponseEntity.ok(cityDto);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody CityPostReqDto cityPostReqDto){
        CityDto cityDto = cityService.save(cityPostReqDto);
        return ResponseEntity.ok(cityDto);
    }

    @PutMapping
    public ResponseEntity update(@RequestBody CityUpdateReqDto cityUpdateReqDto){
        CityDto cityDto = cityService.update(cityUpdateReqDto);
        return ResponseEntity.ok(cityDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        cityService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
