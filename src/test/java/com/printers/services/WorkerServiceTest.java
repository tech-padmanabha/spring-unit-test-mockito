package com.printers.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.printers.entities.Worker;
import com.printers.exception.WorkerNotFoundException;
import com.printers.models.WorkerMapper;
import com.printers.repository.WorkerRepository;
import com.printers.views.WorkerDto;

//@ExtendWith(MockitoExtension.class)
public class WorkerServiceTest {

    @Mock
    private WorkerRepository workerRepository;

    @InjectMocks
    private WorkerService workerService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetWorkerById_Success() {
        Long workerId = 1L;
        Worker worker = new Worker();
        worker.setWorkerId(workerId);
        worker.setFullName("John Doe");
        WorkerDto workerDto = WorkerMapper.toDto(worker);

        when(workerRepository.findById(workerId)).thenReturn(Optional.of(worker));

        WorkerDto result = workerService.getWorkerById(workerId);

        assertEquals(workerDto, result);
    }

    @Test
    public void testGetWorkerById_NotFound() {
        Long workerId = 1L;

        when(workerRepository.findById(workerId)).thenReturn(Optional.empty());

        assertThrows(WorkerNotFoundException.class, () -> workerService.getWorkerById(workerId));
    }

    @Test
    public void testUpdateWorker_Success() {
        Long workerId = 1L;
        WorkerDto workerDto = new WorkerDto(workerId,"John Doe", LocalDate.of(2017, 11, 12), "Developer");
        Worker worker = new Worker();
        worker.setWorkerId(workerId);
        worker.setFullName("Jane Doe");
        worker.setDateOfBirth(LocalDate.of(1990, 1, 1));
        worker.setPosition("Manager");

        when(workerRepository.findById(workerId)).thenReturn(Optional.of(worker));
        when(workerRepository.save(worker)).thenReturn(worker);

        WorkerDto updatedWorkerDto = workerService.updateWorker(workerId, workerDto);

        assertEquals(workerDto.fullName(), updatedWorkerDto.fullName());
        assertEquals(workerDto.dateOfBirth(), updatedWorkerDto.dateOfBirth());
        assertEquals(workerDto.position(), updatedWorkerDto.position());
    }

    @Test
    public void testUpdateWorker_NotFound() {
        Long workerId = 1L;
        WorkerDto workerDto = new WorkerDto(workerId,"John Doe", LocalDate.of(1993, 03, 12), "Developer");

        when(workerRepository.findById(workerId)).thenReturn(Optional.empty());

        assertThrows(WorkerNotFoundException.class, () -> workerService.updateWorker(workerId, workerDto));
    }

    @Test
    public void testUpdateWorkerPartially_Success() {
        Long workerId = 1L;
        WorkerDto workerDto = new WorkerDto(workerId, "John Doe", LocalDate.of(1993, 3, 12), "Developer");
        Worker worker = new Worker();
        worker.setWorkerId(workerId);
        worker.setFullName("Jane Doe");
        worker.setDateOfBirth(LocalDate.of(1990, 1, 1));
        worker.setPosition("Manager");

        when(workerRepository.findById(workerId)).thenReturn(Optional.of(worker));
        when(workerRepository.save(worker)).thenReturn(worker);

        WorkerDto updatedWorkerDto = workerService.updateWorkerPartially(workerId, workerDto);

        assertEquals(workerDto.fullName(), updatedWorkerDto.fullName());
        assertEquals(workerDto.dateOfBirth(), updatedWorkerDto.dateOfBirth());
        assertEquals(workerDto.position(), updatedWorkerDto.position());
    }

    @Test
    public void testUpdateWorkerPartially_NotFound() {
        Long workerId = 1L;
        WorkerDto workerDto = new WorkerDto(workerId, "John Doe", LocalDate.of(1993, 3, 12), "Developer");

        when(workerRepository.findById(workerId)).thenReturn(Optional.empty());

        assertThrows(WorkerNotFoundException.class, () -> workerService.updateWorkerPartially(workerId, workerDto));
    }

    @Test
    public void testDeleteWorker_Success() {
        Long workerId = 1L;

        when(workerRepository.existsById(workerId)).thenReturn(true);

        boolean result = workerService.deleteWorker(workerId);

        assertEquals(true, result);
    }

    @Test
    public void testDeleteWorker_NotFound() {
        Long workerId = 1L;

        when(workerRepository.existsById(workerId)).thenReturn(false);

        assertThrows(WorkerNotFoundException.class, () -> workerService.deleteWorker(workerId));
    }

    @Test
    public void testGetAllWorkers_Success() {
        Worker worker1 = new Worker();
        worker1.setWorkerId(1L);
        worker1.setFullName("John Doe");
        worker1.setDateOfBirth(LocalDate.of(1990, 1, 1));
        worker1.setPosition("Developer");

        Worker worker2 = new Worker();
        worker2.setWorkerId(2L);
        worker2.setFullName("Jane Doe");
        worker2.setDateOfBirth(LocalDate.of(1992, 2, 2));
        worker2.setPosition("Manager");

        List<Worker> workers = List.of(worker1, worker2);
        when(workerRepository.findAll()).thenReturn(workers);

        List<WorkerDto> result = workerService.getAllWorkers();

        assertEquals(2, result.size());
        assertEquals("John Doe", result.get(0).fullName());
        assertEquals("Jane Doe", result.get(1).fullName());
    }

   // @Test
    public void testCreateWorker_Success() {
        WorkerDto workerDto = new WorkerDto(1L, "John Doe", LocalDate.of(1993, 3, 12), "Developer");
        Worker worker = WorkerMapper.toEntity(workerDto);
        worker.setWorkerId(1L);

        when(workerRepository.save(WorkerMapper.toEntity(workerDto))).thenReturn(worker);

        WorkerDto createdWorkerDto = workerService.createWorker(workerDto);

        assertEquals("John Doe", createdWorkerDto.fullName());
        assertEquals(LocalDate.of(1993, 3, 12), createdWorkerDto.dateOfBirth());
        assertEquals("Developer", createdWorkerDto.position());
    }


}