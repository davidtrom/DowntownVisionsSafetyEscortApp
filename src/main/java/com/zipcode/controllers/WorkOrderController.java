package com.zipcode.controllers;

import com.zipcode.exceptions.WorkOrderNotFoundException;
import com.zipcode.models.WorkOrder;
import com.zipcode.models.WorkOrderStatus.WorkOrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import com.zipcode.services.WorkOrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;

@RestController
@RequestMapping("/workOrders")
public class WorkOrderController {

    @Autowired
    private WorkOrderService workOrderService;

    @PostMapping("/create")
    public ResponseEntity createWorkOrder(@RequestBody WorkOrder workOrder)  {
        workOrderService.createWorkOrder(workOrder);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Iterable<WorkOrder>> displayAllWorkOrders(){
        return new ResponseEntity<>(workOrderService.displayAllWorkOrders(), HttpStatus.OK);
    }

    @GetMapping("/{workOrderId}")
    public ResponseEntity<WorkOrder> displayOneWorkOrder (@PathVariable Long workOrderId){
        return new ResponseEntity<>(workOrderService.findWorkOrderById(workOrderId), HttpStatus.OK);
    }
    
    @PutMapping("/{workOrderId}/updateStatus/")
    public ResponseEntity<WorkOrder> updateWorkOrderStatus(@PathVariable Long  workOrderId, @RequestBody WorkOrderStatus workOrderStatus)    {
        WorkOrder workOrder = workOrderService.findWorkOrderById(workOrderId);
        if(workOrder == null)   {
            throw new WorkOrderNotFoundException();
        }
        workOrderService.updateWorkOrderStatus(workOrder, workOrderStatus);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/{workOrderId}/updateDescription")
    public ResponseEntity<WorkOrder> updateWorkOrderDescription(@PathVariable Long workOrderId, @RequestBody String workOrderDescription)   {
        WorkOrder workOrder = workOrderService.findWorkOrderById(workOrderId);
        if(workOrder == null)   {
            throw new WorkOrderNotFoundException();
        }
        workOrderService.updateWorkOrderDescription(workOrder, workOrderDescription);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/workOrderByStatus")
    public ResponseEntity <Iterable<WorkOrder>> findWorkOrdersByStatus( WorkOrderStatus workOrderStatus)   {
        Iterable<WorkOrder> workOrders = workOrderService.findWorkOrdersByStatus(workOrderStatus);
        if(workOrders == null)  {
            throw new WorkOrderNotFoundException();
        }
        return new ResponseEntity<>(workOrders, HttpStatus.OK);
    }

    @PutMapping("/{workOrderId}/updateCreatedDate")
    public ResponseEntity<WorkOrder> updateWorkOrderCreatedDate(@PathVariable Long workOrderId, @RequestBody LocalDate date)    {
        WorkOrder workOrder = workOrderService.findWorkOrderById(workOrderId);
        if(workOrder == null)   {
            throw new WorkOrderNotFoundException();
        }
        workOrderService.updateWorkOrderCreatedDate(workOrder, date);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{workOrderId}/updateCompletedDate")
    public ResponseEntity<WorkOrder> updateWorkOrderCompletedDate(@PathVariable Long workOrderId, @RequestBody LocalDate date)  {
        WorkOrder workOrder = workOrderService.findWorkOrderById(workOrderId);
        if(workOrder == null)   {
            throw new WorkOrderNotFoundException();
        }
        workOrderService.updateWorkOrderCompletedDate(workOrder, date);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}

