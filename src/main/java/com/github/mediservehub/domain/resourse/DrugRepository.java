package com.github.mediservehub.domain.resourse;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RestResource;

public interface DrugRepository extends PagingAndSortingRepository<Drug, Long> {
    @RestResource(rel = "drug")
    Drug findById(Long id);
}
