package com.zipcode.services;

import com.zipcode.models.WorkOrderRequest;
import com.zipcode.repositories.WorkOrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkOrderRequestService {

    @Autowired

    private WorkOrderRepo workOrderRepo;

    //new

    //update

    //delete

    //get methods

    public Iterable<WorkOrderRequest> displayAllWorkOrders (){
        return workOrderRepo.findAll();
    }

    public WorkOrderRequest findWorkOrderById(Long reportID){
        if (workOrderRepo.findById(reportID).isPresent()) {
            return workOrderRepo.findById(reportID).get();
        }
        else{
            return null;
        }
    }

    public WorkOrderRequest createWorkOrder (WorkOrderRequest workOrderRequest) {
        workOrderRequest.setFirstName(workOrderRequest.getFirstName());
        workOrderRequest.setLastName(workOrderRequest.getLastName());
        workOrderRequest.setMessage(workOrderRequest.getMessage());
        workOrderRequest.setLocation(workOrderRequest.getLocation());
        workOrderRequest.setDate(workOrderRequest.getDate());
        return workOrderRepo.save(workOrderRequest);
    }

    public Boolean deleteWorkOrder (Long workOrderId) {
        if(workOrderRepo.findById(workOrderId).isPresent()) {
            workOrderRepo.deleteById(workOrderId);
            return true;
        }
        else {
            return false;
        }
    }

    public void markWorkOrderAsCompleted(WorkOrderRequest workOrderRequest) {

    }

}
