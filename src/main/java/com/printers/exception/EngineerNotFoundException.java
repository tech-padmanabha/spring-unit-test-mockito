package com.printers.exception;

public class EngineerNotFoundException extends RuntimeException{
    
    public EngineerNotFoundException(Long id){
        super("Engineer not found with id:"+ id);
    }
    
}
