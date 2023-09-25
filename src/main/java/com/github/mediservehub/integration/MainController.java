package com.github.mediservehub.integration;

import com.github.mediservehub.domain.resourse.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.PersistentEntityResource;
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@RepositoryRestController
@RequiredArgsConstructor
public class MainController {

    private final FoodStorageRepository storageRepository;
    private final PatientRepository patientRepository;
    private final StockRepository stockRepository;


    @GetMapping(value = "start/foodStorages")
    @PreAuthorize("hasRole('ROLE_MANAGER')")
    @ResponseBody
    public PersistentEntityResource getFoodStorage(@PageableDefault(size = 20, page = 0, sort = "id") Pageable pageable,
                                                   PersistentEntityResourceAssembler asm) {
        Page<FoodStorage> foodStorages = storageRepository.findAll(pageable);

        List<Food> foods = new ArrayList<>();
        foodStorages.stream().forEach(el -> foods.addAll(el.getFoodList()));

        return asm.toFullResource(foods);
    }

    @GetMapping(value = "start/patients")
    @PreAuthorize("hasRole('ROLE_DOCTOR')")
    @ResponseBody
    public PersistentEntityResource getPatients(@PageableDefault(size = 20, page = 0, sort = "id") Pageable pageable,
                                                PersistentEntityResourceAssembler asm) {
        return asm.toFullResource(patientRepository.findAll(pageable));
    }

    @GetMapping(value = "start/stocks")
    @PreAuthorize("hasAnyRole('ROLE_DOCTOR', 'ROLE_MANAGER')")
    @ResponseBody
    public PersistentEntityResource getStock(@PageableDefault(size = 20, page = 0, sort = "id") Pageable pageable,
                                             PersistentEntityResourceAssembler asm) {
        return asm.toFullResource(stockRepository.findAll(pageable));
    }
}
