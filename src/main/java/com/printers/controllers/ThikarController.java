package com.printers.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.printers.services.ThikadarService;
import com.printers.views.SuccessResponse;
import com.printers.views.ThikarDto;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/v2/thikadar")
public class ThikarController {
    
    private ThikadarService thikadarService;


    @GetMapping
    public ThikarDto getThikadarName(@RequestParam Long id) {
        return thikadarService.getThikadarName(id);
    }

    @PostMapping
    public ThikarDto createThikadar(@RequestBody ThikarDto thikadar){
        return thikadarService.createThikadar(thikadar);
    }

    @DeleteMapping
    public SuccessResponse removeThikadar(@RequestParam Long id){
        if(thikadarService.deleteThikadar(id)){
            SuccessResponse.of("Deleted");
        }
        return SuccessResponse.of("Delete Failed");
    }

    @PutMapping
    public ThikarDto updateThikadar(@RequestParam Long id,@RequestBody ThikarDto dto){
        return thikadarService.updateThikadar(id,dto);
    }
}
