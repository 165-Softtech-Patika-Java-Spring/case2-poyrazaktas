package com.poyrazaktas.case2poyrazaktas.adr.controller;

import com.poyrazaktas.case2poyrazaktas.adr.dto.AdrAddressDto;
import com.poyrazaktas.case2poyrazaktas.adr.dto.AdrAddressPostReqDto;
import com.poyrazaktas.case2poyrazaktas.adr.dto.AdrAddressUpdateReqDto;
import com.poyrazaktas.case2poyrazaktas.adr.service.AdrAddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/addresses")
public class AdrAddressController {
    private final AdrAddressService addressService;

    @GetMapping("/findAll")
    public ResponseEntity findAll(){
        return ResponseEntity.ok(addressService.findAll());
    }
    @GetMapping("/get/{id}")
    public ResponseEntity get(@PathVariable Long id){
        AdrAddressDto addressDto = addressService.get(id);
        return ResponseEntity.ok(addressDto);
    }
    @PostMapping("/save")
    public ResponseEntity save(@RequestBody AdrAddressPostReqDto addressPostReqDto){
        AdrAddressDto addressDto = addressService.save(addressPostReqDto);
        return ResponseEntity.ok(addressDto);
    }

    @PutMapping("/update")
    public ResponseEntity update(@RequestBody AdrAddressUpdateReqDto addressUpdateReqDto){
        AdrAddressDto addressDto = addressService.update(addressUpdateReqDto);
        return ResponseEntity.ok(addressDto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        addressService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
