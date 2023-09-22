//package com.github.mediservehub.integration;
//
//import com.github.mediservehub.domain.resourse.*;
//import lombok.RequiredArgsConstructor;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.rest.webmvc.PersistentEntityResource;
//import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
//import org.springframework.data.rest.webmvc.RepositoryRestController;
//import org.springframework.data.web.PageableDefault;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@RepositoryRestController
//@RequiredArgsConstructor
//@RequestMapping(value = "/start")
//public class MainController {
//
//    private final FoodStorageRepository storageRepository;
//    private final PatientRepository patientRepository;
//    private final StockRepository stockRepository;
//
//    private Food food;
//
//    @RequestMapping(value = "/foodStorages", method = RequestMethod.GET)
//    @PreAuthorize("hasRole('ROLE_MANAGER')")
////    @ResponseBody
//    public ResponseEntity<List<Food>> getFoodStorage(@PageableDefault(size = 20, page = 0, sort = "id") Pageable pageable) {
////                                                   PersistentEntityResourceAssembler asm) {
//        Page<FoodStorage> foodStorages = storageRepository.findAll(pageable);
//
//        List<Food> foods = new ArrayList<>();
//        foodStorages.stream().forEach(el -> foods.addAll(el.getFoodList()));
//
////        return asm.toFullResource(foods);
//        return new ResponseEntity<>(foods, HttpStatus.OK);
//    }
//
////    @RequestMapping(value = "/patients", method = RequestMethod.GET)
////    @PreAuthorize("hasRole('ROLE_DOCTOR')")
////    @ResponseBody
////    public PersistentEntityResource getPatients(@PageableDefault(size = 20, page = 0, sort = "id") Pageable pageable,
////                                                PersistentEntityResourceAssembler asm) {
////        return asm.toFullResource(patientRepository.findAll(pageable));
////    }
////
////    @RequestMapping(value = "/stocks", method = RequestMethod.GET)
////    @PreAuthorize("hasAnyRole('ROLE_DOCTOR', 'ROLE_MANAGER')")
////    @ResponseBody
////    public PersistentEntityResource getStock(@PageableDefault(size = 20, page = 0, sort = "id") Pageable pageable,
////                                             PersistentEntityResourceAssembler asm) {
////        return asm.toFullResource(stockRepository.findAll(pageable));
////    }
//}
