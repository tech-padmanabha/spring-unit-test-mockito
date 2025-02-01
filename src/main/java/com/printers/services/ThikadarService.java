package com.printers.services;

import com.printers.views.ThikarDto;

public interface ThikadarService {
    public ThikarDto getThikadarName(Long id);
    public ThikarDto createThikadar(ThikarDto thikarDto);
    public ThikarDto updateThikadar(Long id,ThikarDto thikarDto);
    public boolean deleteThikadar(Long id);
}
