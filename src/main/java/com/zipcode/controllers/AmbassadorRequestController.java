package com.zipcode.controllers;

import com.zipcode.exceptions.AmbassadorRequestNotFoundException;
import com.zipcode.models.AmbassadorRequest;
import com.zipcode.services.AmbassadorRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ambassador-requests")
public class AmbassadorRequestController {

    @Autowired
    private AmbassadorRequestService ambassadorRequestService;

    @PostMapping("/create")
    public ResponseEntity createAmbassadorRequest(@RequestBody AmbassadorRequest ambassadorRequest) {
        ambassadorRequestService.createRequest(ambassadorRequest);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Iterable<AmbassadorRequest>> findAllAmbassadorRequests(){
        return new ResponseEntity<>(ambassadorRequestService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{requestId}")
    public ResponseEntity<AmbassadorRequest> findRequestById (@PathVariable Long requestId){
        AmbassadorRequest request = ambassadorRequestService.findRequestById(requestId);
        if(request == null) {
            throw new AmbassadorRequestNotFoundException();
        }
        return new ResponseEntity<>(request, HttpStatus.OK);
    }

//    @GetMapping("/{firstName}")
//    public ResponseEntity<Iterable<AmbassadorRequest>> findAllRequestsByFirstName (@PathVariable String firstName){
//        Iterable<AmbassadorRequest> requests = ambassadorRequestService.findAllRequestsByFirstName(firstName);
//        if(requests == null) {
//            throw new AmbassadorRequestNotFoundException();
//        }
//        return new ResponseEntity<>(requests, HttpStatus.OK);
//    }
//    @GetMapping("/{lastName}")
//    public ResponseEntity<Iterable<AmbassadorRequest>> findAllRequestsByLastName (@PathVariable String lastName){
//        Iterable<AmbassadorRequest> requests = ambassadorRequestService.findAllRequestsByLastName(lastName);
//        if(requests == null) {
//            throw new AmbassadorRequestNotFoundException();
//        }
//        return new ResponseEntity<>(requests, HttpStatus.OK);
//    }

    @PutMapping("/{requestId}/update-pickup-location/")
    public ResponseEntity<AmbassadorRequest> updatePickUpLocation(@PathVariable Long requestId, @RequestBody String newPickUpLocation)    {
        AmbassadorRequest request = ambassadorRequestService.findRequestById(requestId);
        if(request == null)   {
            throw new AmbassadorRequestNotFoundException();
        }
        ambassadorRequestService.updatePickUpLocation(request, newPickUpLocation);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/{requestId}/update-drop-off-location")
    public ResponseEntity<AmbassadorRequest> updateWorkOrderDescription(@PathVariable Long requestId, @RequestBody String newDropOffLocation)   {
        AmbassadorRequest request = ambassadorRequestService.findRequestById(requestId);
        if(request == null)   {
            throw new AmbassadorRequestNotFoundException();
        }
        ambassadorRequestService.updateDropOffLocation(request, newDropOffLocation);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{requestId}/update-first-name/")
    public ResponseEntity<AmbassadorRequest> updateFirstName(@PathVariable Long requestId, @RequestBody String newFirstName)    {
        AmbassadorRequest request = ambassadorRequestService.findRequestById(requestId);
        if(request == null)   {
            throw new AmbassadorRequestNotFoundException();
        }
        ambassadorRequestService.updateFirstName(request, newFirstName);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/{requestId}/update-last-name/")
    public ResponseEntity<AmbassadorRequest> updateLastName(@PathVariable Long requestId, @RequestBody String newLastName)    {
        AmbassadorRequest request = ambassadorRequestService.findRequestById(requestId);
        if(request == null)   {
            throw new AmbassadorRequestNotFoundException();
        }
        ambassadorRequestService.updateFirstName(request, newLastName);
        return new ResponseEntity(HttpStatus.OK);
    }
}
