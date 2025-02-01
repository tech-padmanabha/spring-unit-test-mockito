package com.printers.services.impl;

import org.springframework.stereotype.Service;

import com.printers.exception.EngineerNotFoundException;
import com.printers.models.EngineerMapper;
import com.printers.repository.EngineerRepository;
import com.printers.services.EngineerService;
import com.printers.views.EngineerDto;

import lombok.AllArgsConstructor;

// @AllArgsConstructor
// @Service
// public class EngineerServiceImpl implements EngineerService{
    
//     private EngineerRepository engineerRepository;

//     @Override
//     public EngineerDto getEngineerById(Long id) {
//         return engineerRepository.findById(id)
//               .map(EngineerMapper::toDto)
//               .orElseThrow(() -> new EngineerNotFoundException(id));
//     }
    
// }
