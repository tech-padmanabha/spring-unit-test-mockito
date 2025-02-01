package com.printers.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.printers.services.EngineerService;
import com.printers.views.EngineerDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class EngineerController implements EngineerService{

    @Override
    public EngineerDto getEngineerById(Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'getEngineerById'");
    }

}
