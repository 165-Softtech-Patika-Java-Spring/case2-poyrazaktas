package com.poyrazaktas.case2poyrazaktas.dst.controller;

import com.poyrazaktas.case2poyrazaktas.dst.dto.DstDistrictDto;
import com.poyrazaktas.case2poyrazaktas.dst.dto.DstDistrictPostReqDto;
import com.poyrazaktas.case2poyrazaktas.dst.dto.DstDistrictUpdateReqDto;
import com.poyrazaktas.case2poyrazaktas.dst.service.DstDistrictService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/districts")
public class DstDistrictController {
    private final DstDistrictService districtService;

    @GetMapping
    public ResponseEntity findAll(){
        return ResponseEntity.ok(districtService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable Long id){
        DstDistrictDto districtDto = districtService.get(id);
        return ResponseEntity.ok(districtDto);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody DstDistrictPostReqDto districtPostReqDto){
        DstDistrictDto districtDto = districtService.save(districtPostReqDto);
        return ResponseEntity.ok(districtDto);
    }

    @PutMapping
    public ResponseEntity update(@RequestBody DstDistrictUpdateReqDto districtUpdateReqDto){
        DstDistrictDto districtDto = districtService.update(districtUpdateReqDto);
        return ResponseEntity.ok(districtDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        districtService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
