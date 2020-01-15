package com.zipcode.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Ambassador not found")
public class AmbassadorNotFoundException extends RuntimeException {


    public AmbassadorNotFoundException(){
        super();
    }


}
