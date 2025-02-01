package com.printers.services.impl;

import org.springframework.stereotype.Service;

import com.printers.services.ThikadarService;
import com.printers.views.ThikarDto;

@Service
public class ThikadarServiceImpl implements ThikadarService{
    

    public ThikarDto getThikadarName(Long id) {
        return ThikarDto.builder()
            .name("Thikadar")
            .property(100000.0)
            .valueInSocity("No :"+id+" Thikadar")
            .build();
    }

    public ThikarDto createThikadar(ThikarDto thikarDto) {
        thikarDto.setValueInSocity("No ! Thikadar");
        return thikarDto;
    }

    public ThikarDto updateThikadar(Long id,ThikarDto thikarDto) {
        thikarDto.setValueInSocity("No ! Thikadar Updated:"+id);
        return thikarDto;
    }

    public boolean deleteThikadar(Long id) {
       return id==1;
    }
}
