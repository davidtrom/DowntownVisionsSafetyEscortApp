package com.zipcode.models;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

public class WorkOrderFileLocation {

    String awsUrl = "${endpointUrl}";
    String awsEndPoint;

    WorkOrder workOrder;
    @ManyToOne
    List<WorkOrderFileLocation> workOrderFileLocations;

    public WorkOrderFileLocation(String awsUrl, String awsEndPoint, WorkOrder workOrder) {
        this.awsUrl = awsUrl;
        this.awsEndPoint = awsEndPoint;
        this.workOrder = workOrder;
    }
}
