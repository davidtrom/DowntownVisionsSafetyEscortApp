package com.zipcode.services;

import com.zipcode.models.WorkOrder;
import com.zipcode.repositories.WorkOrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebSocketService {

    @Autowired
    private WorkOrderRepo workOrderRepo;

    public WorkOrder create(WorkOrder order){
        return order;
    }
}
