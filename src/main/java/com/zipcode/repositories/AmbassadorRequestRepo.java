package com.zipcode.repositories;

import com.zipcode.models.AmbassadorRequest;
import com.zipcode.models.WorkOrderAndRequestStatus.AmbassadorRequestStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AmbassadorRequestRepo extends CrudRepository<AmbassadorRequest, Long> {
Iterable<AmbassadorRequest> findAmbassadorRequestsByFirstName(String firstName);
Iterable<AmbassadorRequest> findAmbassadorRequestsByLastName(String lastName);
AmbassadorRequest findAmbassadorRequestByPhoneNumber(String phoneNumber);
//Iterable<AmbassadorRequest> findAmbassadorRequestsByAmbassadorId(Long ambassadorId);
Iterable<AmbassadorRequest> findAmbassadorRequestByAmbassadorRequestStatus(AmbassadorRequestStatus status);
}
