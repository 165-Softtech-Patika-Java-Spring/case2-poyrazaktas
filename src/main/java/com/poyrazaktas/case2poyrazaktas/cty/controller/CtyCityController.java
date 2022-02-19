package com.poyrazaktas.case2poyrazaktas.cty.controller;

import com.poyrazaktas.case2poyrazaktas.cty.dto.CtyCityDto;
import com.poyrazaktas.case2poyrazaktas.cty.dto.CtyCityPostReqDto;
import com.poyrazaktas.case2poyrazaktas.cty.dto.CtyCityUpdateReqDto;
import com.poyrazaktas.case2poyrazaktas.cty.service.CtyCityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/cities")
public class CtyCityController {
    private final CtyCityService cityService;

    @GetMapping
    public ResponseEntity findAll(){
        return ResponseEntity.ok(cityService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable Long id){
        CtyCityDto cityDto = cityService.get(id);
        return ResponseEntity.ok(cityDto);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody CtyCityPostReqDto cityPostReqDto){
        CtyCityDto cityDto = cityService.save(cityPostReqDto);
        return ResponseEntity.ok(cityDto);
    }

    @PutMapping
    public ResponseEntity update(@RequestBody CtyCityUpdateReqDto cityUpdateReqDto){
        CtyCityDto cityDto = cityService.update(cityUpdateReqDto);
        return ResponseEntity.ok(cityDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        cityService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
