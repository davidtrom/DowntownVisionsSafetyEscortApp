package com.zipcode.DTVApp.repositories;

import com.zipcode.DTVApp.models.ReportConcern;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportedConcernsRepo extends JpaRepository <ReportConcern, Long> {
}
