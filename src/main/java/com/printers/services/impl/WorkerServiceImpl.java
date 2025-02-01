package com.printers.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.printers.exception.WorkerNotFoundException;
import com.printers.models.WorkerMapper;
import com.printers.repository.WorkerRepository;
import com.printers.services.WorkerService;
import com.printers.views.WorkerDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class WorkerServiceImpl implements WorkerService{
    private final WorkerRepository workerRepository;

    public WorkerDto getWorkerById(Long workerId) {
        return workerRepository.findById(workerId)
                .map(WorkerMapper::toDto)
                .orElseThrow(() -> new WorkerNotFoundException(workerId));
    }
    
    @Transactional
    public WorkerDto createWorker(WorkerDto workerDto) {
        if(workerRepository.existsById(workerDto.workerId())){
            throw new WorkerNotFoundException("Worker is already available with the ID :"+workerDto.workerId());
        }
        var workerRet = workerRepository.save(WorkerMapper.toEntity(workerDto));
        return WorkerMapper.toDto(workerRet);
    }

    @Transactional
    public WorkerDto updateWorker(Long workerId, WorkerDto workerDto) {
        return workerRepository.findById(workerId)
                .map(worker -> {
                    worker.setFullName(workerDto.fullName());
                    worker.setDateOfBirth(workerDto.dateOfBirth());
                    worker.setPosition(workerDto.position());
                    return WorkerMapper.toDto(workerRepository.save(worker));
                })
                .orElseThrow(() -> new WorkerNotFoundException(workerId));
    }
    
  
    public WorkerDto updateWorkerPartially(Long workerId, WorkerDto workerDto) {
        return workerRepository.findById(workerId)
                .map(woker ->{
                    if(workerDto.fullName() != null) woker.setFullName(workerDto.fullName());
                    if(workerDto.dateOfBirth() != null) woker.setDateOfBirth(workerDto.dateOfBirth());
                    if(workerDto.position() != null) woker.setPosition(workerDto.position());
                    return WorkerMapper.toDto(workerRepository.save(woker));
                })
                .orElseThrow(() -> new WorkerNotFoundException("Worker is not available with the ID :"+workerId));
    }

    @Transactional
    public boolean deleteWorker(Long workerId) {
        boolean exists = workerRepository.existsById(workerId);
        if (!exists) throw new WorkerNotFoundException(workerId);
        else workerRepository.deleteById(workerId);
        return true;
    }

    public List<WorkerDto> getAllWorkers() {
        return workerRepository.findAll().stream()
                .map(WorkerMapper::toDto)
                .toList();
    }
}
