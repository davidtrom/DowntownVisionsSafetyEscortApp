package com.zipcode.controllers;

import com.zipcode.models.WorkOrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import com.zipcode.services.WorkOrderRequestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/workorders")
public class WorkOrderRequestController {

    @Autowired
    private WorkOrderRequestService workOrderRequestService;

    @PostMapping("/workorders/create")
    public ResponseEntity createWorkOrder(@RequestBody WorkOrderRequest workOrderRequest)  {
        workOrderRequestService.createWorkOrder(workOrderRequest);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Iterable<WorkOrderRequest>> displayAllWorkOrders(){
        return new ResponseEntity<>(workOrderRequestService.displayAllWorkOrders(), HttpStatus.OK);
    }

    @GetMapping("/{workordersId}")
    public ResponseEntity<WorkOrderRequest> displayOneWorkOrder (@PathVariable Long workordersId){
        return new ResponseEntity<>(workOrderRequestService.findWorkOrderById(workordersId), HttpStatus.OK);
    }
    
    @PutMapping("/workorder")
    public ResponseEntity changeWorkOrderStatus(){
        return null;
    }

}

