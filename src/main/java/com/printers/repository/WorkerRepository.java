package com.printers.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.printers.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long> {
}
