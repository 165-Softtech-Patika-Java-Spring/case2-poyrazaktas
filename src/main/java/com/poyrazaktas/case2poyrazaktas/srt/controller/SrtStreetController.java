package com.poyrazaktas.case2poyrazaktas.srt.controller;

import com.poyrazaktas.case2poyrazaktas.srt.dto.SrtStreetDto;
import com.poyrazaktas.case2poyrazaktas.srt.dto.SrtStreetPostReqDto;
import com.poyrazaktas.case2poyrazaktas.srt.dto.SrtStreetUpdateDto;
import com.poyrazaktas.case2poyrazaktas.srt.service.SrtStreetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/streets")
public class SrtStreetController {
    private final SrtStreetService streetService;

    @GetMapping("/findAll")
    public ResponseEntity findAll(){
        return ResponseEntity.ok(streetService.findAll());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity get(@PathVariable Long id){
        SrtStreetDto srtStreetDto = streetService.get(id);
        return ResponseEntity.ok(srtStreetDto);
    }

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody SrtStreetPostReqDto streetPostReqDto){
        SrtStreetDto srtStreetDto = streetService.save(streetPostReqDto);
        return ResponseEntity.ok(srtStreetDto);
    }

    @PutMapping("/update")
    public ResponseEntity update(@RequestBody SrtStreetUpdateDto streetUpdateDto){
        SrtStreetDto srtStreetDto = streetService.update(streetUpdateDto);
        return ResponseEntity.ok(srtStreetDto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        streetService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
