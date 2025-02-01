package com.printers.services;

import org.springframework.stereotype.Service;

import com.printers.views.ThikarDto;

@Service
public class ThikadarService {
    

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
