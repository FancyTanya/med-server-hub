package com.github.mediservehub.integration;

import com.github.mediservehub.domain.resourse.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.PersistentEntityResource;
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RepositoryRestController
@RequiredArgsConstructor
public class FoodController {

    private final FoodRepository foodRepository;

    @RequestMapping(value = "/food/{id}")
    @ResponseBody
    public PersistentEntityResource getFood(@PathVariable Long id,
                                            PersistentEntityResourceAssembler asm) {
        return asm.toFullResource(foodRepository.findById(id));
    }
}
