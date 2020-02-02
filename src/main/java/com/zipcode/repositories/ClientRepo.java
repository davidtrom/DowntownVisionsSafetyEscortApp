package com.zipcode.repositories;

import com.zipcode.models.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepo extends CrudRepository <Client, Long> {
        Boolean deleteByEmail(String email);
}
