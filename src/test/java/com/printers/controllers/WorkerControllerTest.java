package com.printers.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import com.printers.services.WorkerService;
import com.printers.views.WorkerDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(OrderAnnotation.class)
public class WorkerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private WorkerService workerService;

    @InjectMocks
    private WorkerController workerController;

    WorkerDto workerDto;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        workerDto = new WorkerDto(1L, "John Doe", LocalDate.now(), "Software Engineer");
    }

    @Order(1)
    @Test
    public void testGetWorkerById() throws Exception {
        Long workerId = 1L;

        when(workerService.getWorkerById(workerId)).thenReturn(workerDto);

        mockMvc.perform(get("/api/v1/worker")
                .param("workerId", workerId.toString()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.workerId").value(workerId))
                .andExpect(jsonPath("$.fullName").value("John Doe"));
    }

    @Order(4)
    @Test
    public void testUpdateWorker() throws Exception {
        Long workerId = 1L;
        WorkerDto updatedWorkerDto = new WorkerDto(workerId, "Rachel White", LocalDate.now(), "IT Support");

        when(workerService.updateWorker(workerId, workerDto)).thenReturn(updatedWorkerDto);

        mockMvc.perform(put("/api/v1/worker")
                .param("workerId", workerId.toString())
                .contentType("application/json")
                .content("{\n" +
                        "  \"workerId\": 1,\n" +
                        "  \"fullName\": \"Rachel White\",\n" +
                        "  \"dateOfBirth\": \"1985-08-25\",\n" +
                        "  \"position\": \"IT Support\"\n" +
                        "}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.workerId").value(workerId))
                .andExpect(jsonPath("$.fullName").value("Rachel White"))
                .andExpect(jsonPath("$.position").value("IT Support"));
    }
    @Order(3)
    @Test
    public void testUpdateWorkerPartially() throws Exception {
        Long workerId = 1L;
        WorkerDto updatedWorkerDto = new WorkerDto(workerId, "John Doe", LocalDate.now(), "Senior Developer");

        when(workerService.updateWorkerPartially(workerId, workerDto)).thenReturn(updatedWorkerDto);

        mockMvc.perform(patch("/api/v1/worker")
                .param("workerId", workerId.toString())
                .contentType("application/json")
                .content("{\n" +
                        "  \"position\": \"Senior Developer\"\n" +
                        "}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.workerId").value(workerId))
                .andExpect(jsonPath("$.fullName").value("John Doe"))
                .andExpect(jsonPath("$.position").value("Senior Developer"));
    }
    @Order(2)
    @Test
    public void testGetAllWorkers() throws Exception {
        WorkerDto worker2 = new WorkerDto(2L, "Jane Smith", LocalDate.now(), "Project Manager");
        List<WorkerDto> workers = List.of(workerDto, worker2);

        when(workerService.getAllWorkers()).thenReturn(workers);

        mockMvc.perform(get("/api/v1/worker/all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].workerId").value(workerDto.workerId()))
                .andExpect(jsonPath("$[0].fullName").value(workerDto.fullName()))
                .andExpect(jsonPath("$[0].position").value(workerDto.position()))
                .andExpect(jsonPath("$[1].workerId").value(worker2.workerId()))
                .andExpect(jsonPath("$[1].fullName").value(worker2.fullName()))
                .andExpect(jsonPath("$[1].position").value(worker2.position()));
    }

    @Order(5)
    @Test
    public void testDeleteWorkerSuccess() throws Exception {
        Long workerId = 1L;

        when(workerService.deleteWorker(workerId)).thenReturn(true);

        mockMvc.perform(delete("/api/v1/worker")
                .param("workerId", workerId.toString()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Worker deleted successfully"));
    }
}