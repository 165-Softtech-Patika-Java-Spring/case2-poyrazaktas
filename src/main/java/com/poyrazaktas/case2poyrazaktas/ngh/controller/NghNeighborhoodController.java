package com.poyrazaktas.case2poyrazaktas.ngh.controller;

import com.poyrazaktas.case2poyrazaktas.ngh.dto.NghNeighborhoodDto;
import com.poyrazaktas.case2poyrazaktas.ngh.dto.NghNeighborhoodPostReqDto;
import com.poyrazaktas.case2poyrazaktas.ngh.dto.NghNeighborhoodUpdateReqDto;
import com.poyrazaktas.case2poyrazaktas.ngh.service.NghNeighborhoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/neighborhoods")
public class NghNeighborhoodController {
    private final NghNeighborhoodService neighborhoodService;

    @GetMapping
    public ResponseEntity findAll(){
        return ResponseEntity.ok(neighborhoodService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable Long id){
        NghNeighborhoodDto neighborhoodDto = neighborhoodService.get(id);
        return ResponseEntity.ok(neighborhoodDto);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody NghNeighborhoodPostReqDto neighborhoodPostReqDto){
        NghNeighborhoodDto neighborhoodDto = neighborhoodService.save(neighborhoodPostReqDto);
        return ResponseEntity.ok(neighborhoodDto);
    }

    @PutMapping
    public ResponseEntity update(@RequestBody NghNeighborhoodUpdateReqDto neighborhoodUpdateReqDto){
        NghNeighborhoodDto neighborhoodDto = neighborhoodService.update(neighborhoodUpdateReqDto);
        return ResponseEntity.ok(neighborhoodDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        neighborhoodService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
