package com.printers.views;

import java.time.LocalDate;

public record WorkerDto(
    Long workerId, 
    String fullName, 
    LocalDate dateOfBirth, 
    String position) {
}
