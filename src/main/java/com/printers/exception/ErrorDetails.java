// filepath: /d:/Work_Space/Typescripts/Java-In-VS/springboot-in-vs-code/src/main/java/com/printers/exception/ErrorDetails.java
package com.printers.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class ErrorDetails {
    private int statusCode;
    private String message;
    private String details;
}