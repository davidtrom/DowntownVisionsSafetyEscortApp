package com.zipcode.repositories;

import com.zipcode.models.WorkOrderRequest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkOrderRepo extends CrudRepository<WorkOrderRequest, Long> {
}
