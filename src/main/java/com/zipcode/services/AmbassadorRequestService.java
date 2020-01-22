package com.zipcode.services;

import com.zipcode.exceptions.AmbassadorRequestNotFoundException;
import com.zipcode.models.Ambassador;
import com.zipcode.models.AmbassadorRequest;
import com.zipcode.models.WorkOrderAndRequestStatus.AmbassadorRequestStatus;
import com.zipcode.repositories.AmbassadorRepo;
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
        ambassadorRequest.setDate(ambassadorRequest.getDate());
        ambassadorRequest.setAmbassadorRequestStatus(ambassadorRequest.getAmbassadorRequestStatus());
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

    public Iterable<AmbassadorRequest> findAllByClosedStatus () {
        return ambassadorRequestRepo.findAmbassadorRequestByAmbassadorRequestStatus(AmbassadorRequestStatus.CLOSED);
    }

//    public Iterable<AmbassadorRequest> findRequestsByAmbassadorId(Long ambassadorId) {
//        Iterable<AmbassadorRequest> requests = ambassadorRequestRepo.findAmbassadorRequestsByAmbassadorId(ambassadorId);
//        return requests;
//    }

    public AmbassadorRequest findRequestByPhoneNumber(String phoneNumber) {
        AmbassadorRequest request = ambassadorRequestRepo.findAmbassadorRequestByPhoneNumber(phoneNumber);
        return request;
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
    public void updateFirstName(AmbassadorRequest request, String newFirstName) {
        request.setFirstName(newFirstName);
        ambassadorRequestRepo.save(request);
    }

    public void updateLastName(AmbassadorRequest request, String newLastName) {
        request.setLastName(newLastName);
        ambassadorRequestRepo.save(request);
    }

    public void updatePhoneNumber(AmbassadorRequest request, String newPhoneNumber) {
        request.setPhoneNumber(newPhoneNumber);
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

    public AmbassadorRequest updateRequestStatus(AmbassadorRequest request){
        if(request.getAmbassadorRequestStatus().equals(AmbassadorRequestStatus.OPEN)){
            request.setAmbassadorRequestStatus(AmbassadorRequestStatus.CLOSED);
        }
        else if (request.getAmbassadorRequestStatus().equals(AmbassadorRequestStatus.CLOSED)){
            request.setAmbassadorRequestStatus(AmbassadorRequestStatus.OPEN);
        }
        return ambassadorRequestRepo.save(request);
    }

//    public void updateAmbassador(AmbassadorRequest request, Ambassador newAmbassador) {
//        request.setAmbassador(newAmbassador);
//        ambassadorRequestRepo.save(request);
//    }

    // DELETE
    public void deleteRequest(Long requestId) {
            ambassadorRequestRepo.deleteById(requestId);
    }


}
