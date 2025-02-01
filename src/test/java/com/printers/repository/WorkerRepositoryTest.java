package com.printers.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.printers.entities.Worker;

@DataJpaTest
public class WorkerRepositoryTest {

    @Autowired
    WorkerRepository workerRepository;
    Worker worker;

    @BeforeEach
    void init() {
        worker = new Worker();
        worker.setFullName("Rajesh Khanna");
        worker.setDateOfBirth(LocalDate.now());
        worker.setPosition("Old Actor");
    }

    @Test
    @Transactional
    @Rollback
    @DisplayName("Test for creating a worker")
    void testForCreateWorker() {
        var retWorker = workerRepository.save(worker);
        assertNotNull(retWorker);
        assertNotNull(retWorker.getWorkerId());
    }
    @Test
    @Transactional
    @Rollback
    @DisplayName("Test for Update a worker")
    void testForUpdateWorker() {
        var retWorker = workerRepository.save(worker);
        assertNotNull(retWorker);
        assertNotNull(retWorker.getWorkerId());
        retWorker.setPosition("Old Actor");
        var updatedWorker = workerRepository.save(retWorker);
        assertNotNull(updatedWorker);
        assertNotNull(updatedWorker.getWorkerId());
    }

    @Test
    @Transactional
    @Rollback
    @DisplayName("Test for Delete a worker")
    void testForDeleteWorker() {
        var retWorker = workerRepository.save(worker);
        assertNotNull(retWorker);
        assertNotNull(retWorker.getWorkerId());
        workerRepository.delete(retWorker);
    }
    @Test
    @Transactional
    @Rollback
    @DisplayName("Test for Find a worker")
    void testForFindWorker() {
        var retWorker = workerRepository.save(worker);
        assertNotNull(retWorker);
        assertNotNull(retWorker.getWorkerId());
        var foundWorker = workerRepository.findById(retWorker.getWorkerId());
        assertNotNull(foundWorker);
    }

    @Test
    @DisplayName("Test for Find All workers")
    void testForFindAllWorkers() {
        var retWorker = workerRepository.save(worker);
        assertNotNull(retWorker);
        assertNotNull(retWorker.getWorkerId());
        var workers = workerRepository.findAll();
        assertNotNull(workers);
    }

    @AfterEach
    void distroy() {
        worker = null;
    }
}
