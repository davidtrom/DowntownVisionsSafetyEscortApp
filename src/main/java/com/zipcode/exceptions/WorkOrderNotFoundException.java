package com.zipcode.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "WorkOrder not found")
public class WorkOrderNotFoundException extends RuntimeException{

    public WorkOrderNotFoundException(){
        super();
    }
}
