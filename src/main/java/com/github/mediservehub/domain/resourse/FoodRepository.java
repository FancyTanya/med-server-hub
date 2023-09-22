package com.github.mediservehub.domain.resourse;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RestResource;

public interface FoodRepository extends PagingAndSortingRepository<Food, Long> {
    @RestResource(rel = "food")
    Food findById(Long id);
}
