package com.zipcode.repositories;

import com.zipcode.models.AmbassadorRequest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepo  extends CrudRepository<AmbassadorRequest, Long> {

}
