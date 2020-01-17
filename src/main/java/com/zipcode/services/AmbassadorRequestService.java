package com.zipcode.services;

import com.zipcode.models.Ambassador;
import com.zipcode.models.AmbassadorRequest;
import com.zipcode.repositories.AmbassadorRequestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class AmbassadorRequestService {

    @Autowired
    private AmbassadorRequestRepo ambassadorRequestRepo;

    //new
    public AmbassadorRequest createRequest(AmbassadorRequest ambassadorRequest) {
        ambassadorRequest.setFirstName(ambassadorRequest.getFirstName());
        ambassadorRequest.setLastName(ambassadorRequest.getLastName());
        ambassadorRequest.setPhoneNumber(ambassadorRequest.getPhoneNumber());
        ambassadorRequest.setPickUpLocation(ambassadorRequest.getPickUpLocation());
        ambassadorRequest.setDropOffLocation(ambassadorRequest.getDropOffLocation());
        return ambassadorRequestRepo.save(ambassadorRequest);
    }

    //update


    //delete
    public Boolean deleteRequest (Long requestId) {
        if(ambassadorRequestRepo.findById(requestId).isPresent()) {
            ambassadorRequestRepo.deleteById(requestId);
            return true;
        }
        else {
            return false;
        }
    }

    //get methods

    public Iterable<AmbassadorRequest> displayAllRequests (){
        return ambassadorRequestRepo.findAll();
    }

    public AmbassadorRequest findRequestById(Long requestId){
        AmbassadorRequest request = ambassadorRequestRepo.findById(requestId).get();
        if (request == null) {
            return request;
        }
        else{
            return null;
        }
    }
}
