package com.printers.models;

import com.printers.entities.Worker;
import com.printers.views.WorkerDto;

public class WorkerMapper {
    public static WorkerDto toDto(Worker worker) {
        return new WorkerDto(worker.getWorkerId(), worker.getFullName(), worker.getDateOfBirth(), worker.getPosition());
    }
    public static Worker toEntity(WorkerDto workerDto) {
        Worker worker = new Worker();
        worker.setWorkerId(workerDto.workerId());
        worker.setFullName(workerDto.fullName());
        worker.setDateOfBirth(workerDto.dateOfBirth());
        worker.setPosition(workerDto.position());
        return worker;
    }
}
