package com.zipcode.services;

import com.zipcode.models.AmbassadorRequest;
import com.zipcode.repositories.AmbassadorRequestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AmbassadorRequestService {

    private AmbassadorRequestRepo ambassadorRequestRepo;

    @Autowired
    public AmbassadorRequestService(AmbassadorRequestRepo ambassadorRequestRepo) {
        this.ambassadorRequestRepo = ambassadorRequestRepo;
    }

    // POST
    public void createRequest(AmbassadorRequest ambassadorRequest) {
        ambassadorRequest.setFirstName(ambassadorRequest.getFirstName());
        ambassadorRequest.setLastName(ambassadorRequest.getLastName());
        ambassadorRequest.setPhoneNumber(ambassadorRequest.getPhoneNumber());
        ambassadorRequest.setPickUpLocation(ambassadorRequest.getPickUpLocation());
        ambassadorRequest.setDropOffLocation(ambassadorRequest.getDropOffLocation());
        ambassadorRequestRepo.save(ambassadorRequest);
    }

    // GET

    public Iterable<AmbassadorRequest> findAllRequests() {
        return ambassadorRequestRepo.findAll();
    }

    public AmbassadorRequest findRequestById(Long requestId) {
        AmbassadorRequest request = ambassadorRequestRepo.findById(requestId).get();
        return request;
    }

    public Iterable<AmbassadorRequest> findRequestsByAmbassadorId(Long ambassadorId) {
        Iterable<AmbassadorRequest> requests = ambassadorRequestRepo.findAmbassadorRequestsByAmbassadorId(ambassadorId);
return requests;
    }

    public Iterable<AmbassadorRequest> findAllRequestsByFirstName(String firstName) {
        Iterable<AmbassadorRequest> requests = ambassadorRequestRepo.findAmbassadorRequestsByFirstName(firstName);
        return requests;
    }

    public Iterable<AmbassadorRequest> findAllRequestsByLastName(String lastName) {
        Iterable<AmbassadorRequest> requests = ambassadorRequestRepo.findAmbassadorRequestsByLastName(lastName);
        return requests;
    }

    // UPDATE
    public void updateFirstName(Long requestId, String newFirstName) {
        AmbassadorRequest request = findRequestById(requestId);
        request.setFirstName(newFirstName);
        ambassadorRequestRepo.save(request);
    }

    public void updateLastName(Long requestId, String newLastName) {
        AmbassadorRequest request = findRequestById(requestId);
        request.setLastName(newLastName);
        ambassadorRequestRepo.save(request);
    }
    public void updatePhoneNumber(Long requestId, String newPhoneNumber) {
        AmbassadorRequest request = findRequestById(requestId);
        request.setPhoneNumber(newPhoneNumber);
        ambassadorRequestRepo.save(request);
    }

    public void updatePickUpLocation(Long requestId, String newPickUpLocation) {
        AmbassadorRequest request = findRequestById(requestId);
        request.setPickUpLocation(newPickUpLocation);
        ambassadorRequestRepo.save(request);
    }

    public void updateDropOffLocation(Long requestId, String newDropOffLocation) {
        AmbassadorRequest request = findRequestById(requestId);
        request.setDropOffLocation(newDropOffLocation);
        ambassadorRequestRepo.save(request);
    }

    public void updateAmbassadorId(Long requestId, Long newAmbassadorId) {
        AmbassadorRequest request = findRequestById(requestId);
        request.setAmbassadorId(newAmbassadorId);
        ambassadorRequestRepo.save(request);
    }

    // DELETE
    public void deleteRequest(Long requestId) {
            ambassadorRequestRepo.deleteById(requestId);
    }


}
