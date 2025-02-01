package com.printers.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.printers.services.WorkerService;
import com.printers.views.SuccessResponse;
import com.printers.views.WorkerDto;

import org.springframework.web.bind.annotation.RequestBody;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/worker")
public class WorkerController {

    private final WorkerService workerService;

     @GetMapping
     public WorkerDto getWorkerById(@RequestParam Long workerId) {
            return workerService.getWorkerById(workerId);
    }
    @PutMapping
    public WorkerDto updateWorker(@RequestParam Long workerId,@RequestBody WorkerDto workerDto) {
        return workerService.updateWorker(workerId, workerDto);
    }

    @PostMapping
    public WorkerDto createWorker(@RequestBody WorkerDto workerDto) {
        return workerService.createWorker(workerDto);
    }
    @PatchMapping
    public WorkerDto updateWorkerPartially(@RequestParam Long workerId, @RequestBody WorkerDto workerDto) {
        return workerService.updateWorkerPartially(workerId, workerDto);
    }

    @DeleteMapping
    public ResponseEntity<SuccessResponse> deleteWorker(@RequestParam Long workerId) {

        if(workerService.deleteWorker(workerId)) {
            return ResponseEntity.ok(SuccessResponse.of("Worker deleted successfully"));
        }
        else {
            return ResponseEntity.badRequest().body(SuccessResponse.of("Worker not found"));
        }
    }
    @GetMapping("/all")
    public List<WorkerDto> getAllWorkers() {
        return workerService.getAllWorkers();
    }

    
}
