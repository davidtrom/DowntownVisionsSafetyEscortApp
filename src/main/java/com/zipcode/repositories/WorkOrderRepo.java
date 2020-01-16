package com.zipcode.repositories;

import com.zipcode.models.WorkOrder;
import com.zipcode.models.WorkOrderStatus.WorkOrderStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkOrderRepo extends CrudRepository<WorkOrder, Long> {

    Iterable<WorkOrder> findWorkOrdersByWorkOrderStatus(WorkOrderStatus workOrderStatus);

}
