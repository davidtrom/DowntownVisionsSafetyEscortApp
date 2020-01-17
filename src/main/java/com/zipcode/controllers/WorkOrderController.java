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
@RequestMapping("/work-orders")
public class WorkOrderController {

    @Autowired
    private WorkOrderService workOrderService;


    //----------------------------------create----------------------------------

    @PostMapping("/create")
    public ResponseEntity createWorkOrder(@RequestBody WorkOrder workOrder)  {
        workOrderService.createWorkOrder(workOrder);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    //----------------------------------get methods----------------------------------

    @GetMapping
    public ResponseEntity<Iterable<WorkOrder>> displayAllWorkOrders(){
        return new ResponseEntity<>(workOrderService.displayAllWorkOrders(), HttpStatus.OK);
    }

    @GetMapping("/{workOrderId}")
    public ResponseEntity<WorkOrder> findWorkOrderById (@PathVariable Long workOrderId){
        return new ResponseEntity<>(workOrderService.findWorkOrderById(workOrderId), HttpStatus.OK);
    }

    @GetMapping("/work-orders-by-status")
    public ResponseEntity <Iterable<WorkOrder>> findWorkOrdersByStatus( WorkOrderStatus workOrderStatus)   {
        Iterable<WorkOrder> workOrders = workOrderService.findWorkOrdersByStatus(workOrderStatus);
        if(workOrders == null)  {
            throw new WorkOrderNotFoundException();
        }
        return new ResponseEntity<>(workOrders, HttpStatus.OK);
    }

    @GetMapping("/work-orders-by-date-created")
    public ResponseEntity <Iterable<WorkOrder>> findWorkOrdersByDateCreated( LocalDate dateCreated) {
        Iterable<WorkOrder> workOrders = workOrderService.findWorkOrdersByDateCreated(dateCreated);
        if (workOrders == null) {
            throw new WorkOrderNotFoundException();
        }
        return new ResponseEntity<>(workOrders, HttpStatus.OK);
    }

    @GetMapping("/work-orders-by-date-completed")
    public ResponseEntity <Iterable<WorkOrder>> findWorkOrdersByDateCompleted( LocalDate dateCompleted) {
        Iterable<WorkOrder> workOrders = workOrderService.findWorkOrdersByDateCompleted(dateCompleted);
        if (workOrders == null) {
            throw new WorkOrderNotFoundException();
        }
        return new ResponseEntity<>(workOrders, HttpStatus.OK);
    }


    @GetMapping("/work-orders-by-name")
    public ResponseEntity<Iterable<WorkOrder>> findWorkOrdersByName(String lastname, String firstName)  {
        Iterable<WorkOrder> workOrders = workOrderService.findWorkOrdersByName(lastname, firstName);
        if(workOrders == null)  {
            throw new WorkOrderNotFoundException();
        }
        return new ResponseEntity<>(workOrders, HttpStatus.OK);
    }



    //----------------------------------update methods----------------------------------

    @PutMapping("/{workOrderId}/update-status/")
    public ResponseEntity<WorkOrder> updateWorkOrderStatus(@PathVariable Long  workOrderId, @RequestBody WorkOrderStatus workOrderStatus)    {
        WorkOrder workOrder = workOrderService.findWorkOrderById(workOrderId);
        if(workOrder == null)   {
            throw new WorkOrderNotFoundException();
        }
        workOrderService.updateWorkOrderStatus(workOrder, workOrderStatus);
        return new ResponseEntity(HttpStatus.OK);
    }


    @PutMapping("/{workOrderId}/update-description")
    public ResponseEntity<WorkOrder> updateWorkOrderDescription(@PathVariable Long workOrderId, @RequestBody String workOrderDescription)   {
        WorkOrder workOrder = workOrderService.findWorkOrderById(workOrderId);
        if(workOrder == null)   {
            throw new WorkOrderNotFoundException();
        }
        workOrderService.updateWorkOrderDescription(workOrder, workOrderDescription);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PutMapping("/{workOrderId}/update-created-date")
    public ResponseEntity<WorkOrder> updateWorkOrderCreatedDate(@PathVariable Long workOrderId, @RequestBody LocalDate date)    {
        WorkOrder workOrder = workOrderService.findWorkOrderById(workOrderId);
        if(workOrder == null)   {
            throw new WorkOrderNotFoundException();
        }
        workOrderService.updateWorkOrderCreatedDate(workOrder, date);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{workOrderId}/update-completed-date")
    public ResponseEntity<WorkOrder> updateWorkOrderCompletedDate(@PathVariable Long workOrderId, @RequestBody LocalDate date)  {
        WorkOrder workOrder = workOrderService.findWorkOrderById(workOrderId);
        if(workOrder == null)   {
            throw new WorkOrderNotFoundException();
        }
        workOrderService.updateWorkOrderCompletedDate(workOrder, date);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{workOrderId}/update-location")
    public ResponseEntity<WorkOrder> updateWorkOrderLocation(@PathVariable Long workOrderId, @RequestBody String location)  {
        WorkOrder workOrder = workOrderService.findWorkOrderById(workOrderId);
        if(workOrder == null)   {
            throw new WorkOrderNotFoundException();
        }
        workOrderService.updateWorkOrderLocation(workOrder, location);
        return new ResponseEntity<>(HttpStatus.OK);

    }


}

