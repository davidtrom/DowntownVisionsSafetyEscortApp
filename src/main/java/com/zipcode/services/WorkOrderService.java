package com.zipcode.services;

import com.zipcode.models.WorkOrder;
import com.zipcode.models.WorkOrderStatus.WorkOrderStatus;
import com.zipcode.repositories.WorkOrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkOrderService {

    @Autowired

    private WorkOrderRepo workOrderRepo;

    //new

    //update

    //delete

    //get methods

    public Iterable<WorkOrder> displayAllWorkOrders (){
        return workOrderRepo.findAll();
    }

    public WorkOrder findWorkOrderById(Long reportID){
        if (workOrderRepo.findById(reportID).isPresent()) {
            return workOrderRepo.findById(reportID).get();
        }
        else{
            return null;
        }
    }

    public WorkOrder createWorkOrder (WorkOrder workOrder) {
        workOrder.setFirstName(workOrder.getFirstName());
        workOrder.setLastName(workOrder.getLastName());
        workOrder.setDescription(workOrder.getDescription());
        workOrder.setLocation(workOrder.getLocation());
        workOrder.setDate(workOrder.getDate());
        return workOrderRepo.save(workOrder);
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

    public Iterable<WorkOrder> findWorkOrdersByStatus(WorkOrderStatus workOrderStatus)  {
        return workOrderRepo.findWorkOrdersByWorkOrderStatus(workOrderStatus);
    }

    public void updateWorkOrderStatus(WorkOrder workOrder, WorkOrderStatus workOrderStatus) {
         workOrder.setWorkOrderStatus(workOrderStatus);
    }

    public void updateWorkOrderDescription(WorkOrder workOrder, String workOrderDescription)    {

    }

}
