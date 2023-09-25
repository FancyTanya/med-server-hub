package com.github.mediservehub.domain.resourse;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RestResource;

public interface PatientRepository extends PagingAndSortingRepository<Patient, Long> {
    @RestResource(rel = "patient")
    Patient findById(Long id);
}
