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
    public ResponseEntity<Iterable<AmbassadorRequest>> displayAllAmbassadorRequests(){
        return new ResponseEntity<>(ambassadorRequestService.displayAllRequests(), HttpStatus.OK);
    }

    @GetMapping("/{requestId}")
    public ResponseEntity<AmbassadorRequest> displayOneRequest (@PathVariable Long requestId){
        return new ResponseEntity<>(ambassadorRequestService.findRequestById(requestId), HttpStatus.OK);
    }

    @PutMapping("/{requestId}/update-pickup-location/")
    public ResponseEntity<AmbassadorRequest> updateWorkOrderStatus(@PathVariable Long requestId, @RequestBody String newPickUpLocation)    {
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
}
