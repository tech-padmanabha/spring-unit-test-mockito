package com.printers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.printers.entities.Engineer;

@Repository
public interface EngineerRepository  extends JpaRepository<Engineer,Long>{
    
}
