package com.zipcode.controllers;

import com.zipcode.models.WorkOrder;
import com.zipcode.services.AmbassadorService;
import com.zipcode.services.WebSocketService;
import com.zipcode.services.WorkOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebSocketController {

    private WorkOrderService workOrderService;
    private WebSocketService webSocketService;

    @Autowired
    public WebSocketController(WorkOrderService workOrderService, WebSocketService webSocketService) {
        this.workOrderService = workOrderService;
        this.webSocketService = webSocketService;
    }

    @CrossOrigin
    @MessageMapping("/create")
    @SendTo("/topic")
    public WorkOrder order(@RequestBody WorkOrder order) throws Exception {
        Thread.sleep(1000);
        return webSocketService.create(order);
    }


    @PostMapping("/create")
    public ResponseEntity<WorkOrder> createWorkOrder(@RequestBody WorkOrder workOrder) {
        workOrderService.createWorkOrder(workOrder);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
