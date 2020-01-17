package com.zipcode.repositories;

import com.zipcode.models.Ambassador;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@ComponentScan("com.zipcode.repositories")
@Repository
public interface AmbassadorRepo extends CrudRepository<Ambassador, Long> {
    Ambassador findByFirstName(String firstName);
    Ambassador findByLastName(String lastName);
    Ambassador findByFirstNameAndLastName(String firstName, String lastName);
    Iterable<Ambassador> findAmbassadorsByFirstName(String firstName);
    Iterable<Ambassador> findAmbassadorsByLastName(String lastName);
}
