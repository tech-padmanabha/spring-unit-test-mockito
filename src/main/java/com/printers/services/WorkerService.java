package com.printers.services;

import java.util.List;

import com.printers.views.WorkerDto;

public interface WorkerService {
     public WorkerDto getWorkerById(Long workerId);
     public WorkerDto createWorker(WorkerDto workerDto);
     public WorkerDto updateWorker(Long workerId, WorkerDto workerDto) ;
     public WorkerDto updateWorkerPartially(Long workerId, WorkerDto workerDto) ;
     public boolean deleteWorker(Long workerId);
     public List<WorkerDto> getAllWorkers();
}
