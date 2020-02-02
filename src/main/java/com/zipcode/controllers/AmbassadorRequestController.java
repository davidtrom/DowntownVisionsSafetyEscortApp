package com.zipcode.controllers;

import com.zipcode.exceptions.AmbassadorRequestNotFoundException;
import com.zipcode.models.Ambassador;
import com.zipcode.models.AmbassadorRequest;
import com.zipcode.models.WorkOrderAndRequestStatus.AmbassadorRequestStatus;
import com.zipcode.services.AmbassadorRequestService;
import com.zipcode.services.AmbassadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ambassador-requests")
public class AmbassadorRequestController {

    private AmbassadorRequestService ambassadorRequestService;
    private AmbassadorService ambassadorService;

    @Autowired
    public AmbassadorRequestController(AmbassadorRequestService ambassadorRequestService, AmbassadorService ambassadorService) {
        this.ambassadorRequestService = ambassadorRequestService;
        this.ambassadorService = ambassadorService;

    }

    // POST
    @PostMapping("/request")
    public ResponseEntity<AmbassadorRequest> createAmbassadorRequest(@RequestBody AmbassadorRequest ambassadorRequest) {
        ambassadorRequestService.createRequest(ambassadorRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // GET

    @GetMapping
    public ResponseEntity<Iterable<AmbassadorRequest>> findAllAmbassadorRequests(){
        return new ResponseEntity<>(ambassadorRequestService.findAllRequests(), HttpStatus.OK);
    }

    @GetMapping("/{requestId}")
    public ResponseEntity<AmbassadorRequest> findRequestById (@PathVariable Long requestId){
        AmbassadorRequest request = ambassadorRequestService.findRequestById(requestId);
        if(request == null) {
            throw new AmbassadorRequestNotFoundException();
        }
        return new ResponseEntity<>(request, HttpStatus.OK);
    }

    @GetMapping("/{phoneNumber}")
    public ResponseEntity<AmbassadorRequest> findRequestByPhoneNumber (@PathVariable String phoneNumber){
        AmbassadorRequest request = ambassadorRequestService.findRequestByPhoneNumber(phoneNumber);
        if(request == null) {
            throw new AmbassadorRequestNotFoundException();
        }
        return new ResponseEntity<>(request, HttpStatus.OK);
    }

    @GetMapping("/{firstName}")
    public ResponseEntity<Iterable<AmbassadorRequest>> findAllRequestsByFirstName (@PathVariable String firstName){
        Iterable<AmbassadorRequest> requests = ambassadorRequestService.findAllRequestsByFirstName(firstName);
        if(requests == null) {
            throw new AmbassadorRequestNotFoundException();
        }
        return new ResponseEntity<>(requests, HttpStatus.OK);
    }
    @GetMapping("/{lastName}")
    public ResponseEntity<Iterable<AmbassadorRequest>> findAllRequestsByLastName (@PathVariable String lastName){
        Iterable<AmbassadorRequest> requests = ambassadorRequestService.findAllRequestsByLastName(lastName);
        if(requests == null) {
            throw new AmbassadorRequestNotFoundException();
        }
        return new ResponseEntity<>(requests, HttpStatus.OK);
    }

    @GetMapping("/closed")
    public ResponseEntity<Iterable<AmbassadorRequest>> findAllByClosedStatus () {
        Iterable<AmbassadorRequest> requests = ambassadorRequestService.findAllByClosedStatus();
        if(requests == null) {
            throw new AmbassadorRequestNotFoundException();
        }
        return new ResponseEntity<>(requests, HttpStatus.OK);
    }

    @GetMapping("/open")
    public ResponseEntity<Iterable<AmbassadorRequest>> findAllByOpenStatus () {
        Iterable<AmbassadorRequest> requests = ambassadorRequestService.findAllByOpenStatus();
        if(requests == null) {
            throw new AmbassadorRequestNotFoundException();
        }
        return new ResponseEntity<>(requests, HttpStatus.OK);
    }

//    @GetMapping("/ambassador/{ambassadorId}")
//    public ResponseEntity<Iterable<AmbassadorRequest>> findAllRequestsByLastName (@PathVariable Long ambassadorId){
//        Iterable<AmbassadorRequest> requests = ambassadorRequestService.findRequestsByAmbassadorId(ambassadorId);
//        if(requests == null) {
//            throw new AmbassadorRequestNotFoundException();
//        }
//        return new ResponseEntity<>(requests, HttpStatus.OK);
//    }

    // MISSING GET METHODS: by origin, destination, email

    // UPDATE
//    @PutMapping("/{requestId}/ambassador/{ambassadorId}")
//    public ResponseEntity<AmbassadorRequest> updateAmbassador(@PathVariable Long requestId, @PathVariable Long ambassadorId)    {
//        AmbassadorRequest request = ambassadorRequestService.findRequestById(requestId);
//        Ambassador newAmbassador = ambassadorService.findById(ambassadorId);
//
//        if(request == null)   {
//            throw new AmbassadorRequestNotFoundException();
//        }
//        ambassadorRequestService.updateAmbassador(request, newAmbassador);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

    @PutMapping("/{requestId}/update-pickup-location/")
    public ResponseEntity<AmbassadorRequest> updatePickUpLocation(@PathVariable Long requestId, @RequestBody String newPickUpLocation)    {
        AmbassadorRequest request = ambassadorRequestService.findRequestById(requestId);
        if(request == null)   {
            throw new AmbassadorRequestNotFoundException();
        }
        ambassadorRequestService.updatePickUpLocation(request, newPickUpLocation);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{requestId}/drop-off-location")
    public ResponseEntity<AmbassadorRequest> updateDropOffLocation(@PathVariable Long requestId, @RequestBody String newDropOffLocation)   {
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
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{requestId}/update-last-name/")
    public ResponseEntity<AmbassadorRequest> updateLastName(@PathVariable Long requestId, @RequestBody String newLastName)    {
        AmbassadorRequest request = ambassadorRequestService.findRequestById(requestId);
        if(request == null)   {
            throw new AmbassadorRequestNotFoundException();
        }
        ambassadorRequestService.updateLastName(request, newLastName);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{requestId}/update-phone-number/")
    public ResponseEntity<AmbassadorRequest> updatePhoneNumber(@PathVariable Long requestId, @RequestBody String newPhoneNumber)    {
        AmbassadorRequest request = ambassadorRequestService.findRequestById(requestId);
        if(request == null)   {
            throw new AmbassadorRequestNotFoundException();
        }
        ambassadorRequestService.updatePhoneNumber(request, newPhoneNumber);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/close/{requestId}")
    public ResponseEntity<AmbassadorRequest> closeRequest (@PathVariable Long requestId) {
        AmbassadorRequest request = ambassadorRequestService.findRequestById(requestId);
        if(request == null)   {
            throw new AmbassadorRequestNotFoundException();
        }
        ambassadorRequestService.updateRequestStatus(request);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // DELETE
    @DeleteMapping("/{requestId}")
    public ResponseEntity<AmbassadorRequest> deleteWorkOrder(@PathVariable Long requestId)    {
        AmbassadorRequest request = ambassadorRequestService.findRequestById(requestId);
        if(request == null)   {
            throw new AmbassadorRequestNotFoundException();
        }
        else
            ambassadorRequestService.deleteRequest(requestId);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
