package com.zipcode.repositories;

import com.zipcode.models.WorkOrder;
import com.zipcode.models.WorkOrderAndRequestStatus.WorkOrderStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface WorkOrderRepo extends CrudRepository<WorkOrder, Long> {

    Iterable<WorkOrder> findWorkOrdersByWorkOrderStatus(WorkOrderStatus workOrderStatus);
    Iterable<WorkOrder> findWorkOrdersByDateCreated(LocalDate dateCreated);
    Iterable<WorkOrder> findWorkOrdersByDateCompleted(LocalDate dateCompleted);
    Iterable<WorkOrder> findWorkOrdersByLastNameAndFirstName(String lastName, String firstName);


}
