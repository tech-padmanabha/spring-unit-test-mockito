package com.printers.services;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import com.printers.views.EngineerDto;

@HttpExchange("/api/v1/engineer")
public interface EngineerService {
    
    @GetExchange
    EngineerDto getEngineerById(@RequestParam Long id);
}
