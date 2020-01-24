package com.zipcode.repositories;

import com.zipcode.models.UploadedFile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UploadedFileRepo extends CrudRepository<UploadedFile, Long> {
}
