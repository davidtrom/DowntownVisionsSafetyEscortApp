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
        return ambassadorRequestRepo.save(ambassadorRequest);
    }

    //get

    public Iterable<AmbassadorRequest> findAll() {
        return ambassadorRequestRepo.findAll();
    }

    public AmbassadorRequest findRequestById(Long requestId) {
        AmbassadorRequest request = ambassadorRequestRepo.findById(requestId).get();
    }

    public AmbassadorRequest findAllRequestsByFirstName(String firstName) {

    }

    public AmbassadorRequest findAllRequestsByLastName(String lastName) {

    }

    //update
    public void updateFirstName(AmbassadorRequest request, String newFirstName) {
        request.setFirstName(newFirstName);
        ambassadorRequestRepo.save(request);
    }

    public void updateLastName(AmbassadorRequest request, String newLastName) {
        request.setLastName(newLastName);
        ambassadorRequestRepo.save(request);
    }


    public void updatePickUpLocation(AmbassadorRequest request, String newPickUpLocation) {
        request.setPickUpLocation(newPickUpLocation);
        ambassadorRequestRepo.save(request);
    }

    public void updateDropOffLocation(AmbassadorRequest request, String newDropOffLocation) {
        request.setDropOffLocation(newDropOffLocation);
        ambassadorRequestRepo.save(request);
    }


    //delete
    public Boolean deleteRequest(Long requestId) {
        if (ambassadorRequestRepo.findById(requestId).isPresent()) {
            ambassadorRequestRepo.deleteById(requestId);
            return true;
        } else {
            return false;
        }
    }


}
