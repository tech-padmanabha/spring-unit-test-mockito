package com.printers.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.printers.services.ThikadarService;
import com.printers.views.ThikarDto;

@WebMvcTest(ThikarController.class)
public class ThikarControllerTest {
    
    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    ThikadarService thikadarService;

    @Test
    void testGetThikadarById() throws Exception{
        Long thikadarId = 1L;
        ThikarDto dto = ThikarDto.builder()
                                 .name("Prasna")
                                 .property(4949949.4)
                                 .valueInSocity("Bekar he")
                                 .build();
            when(thikadarService.getThikadarName(thikadarId)).thenReturn(dto);

            mockMvc.perform(get("/v2/thikadar").param("id", thikadarId.toString()))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.name").value("Prasna"))
            .andExpect(jsonPath("$.property").value(4949949.4));

    }
    void testUpdateTikadar()throws Exception{
        
    }
}
