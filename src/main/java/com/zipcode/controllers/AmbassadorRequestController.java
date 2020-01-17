package com.zipcode.controllers;

import com.zipcode.models.AmbassadorRequest;
import com.zipcode.services.AmbassadorRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ambassadorRequests")
public class AmbassadorRequestController {

    @Autowired
    private AmbassadorRequestService ambassadorRequestService;

    @PostMapping("/create")
    public ResponseEntity createAmbassadorRequest(@RequestBody AmbassadorRequest ambassadorRequest) {
        ambassadorRequestService.createRequest(ambassadorRequest);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Iterable<AmbassadorRequest>> displayAllAmbassadorRequests(){
        return new ResponseEntity<>(ambassadorRequestService.displayAllRequests(), HttpStatus.OK);
    }

    @GetMapping("/{request-id}")
    public ResponseEntity<AmbassadorRequest> displayOneRequest (@PathVariable Long requestId){
        return new ResponseEntity<>(ambassadorRequestService.findRequestById(requestId), HttpStatus.OK);
    }

}
