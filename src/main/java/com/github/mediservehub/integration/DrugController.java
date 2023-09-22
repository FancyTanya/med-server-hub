package com.github.mediservehub.integration;

import com.github.mediservehub.domain.resourse.DrugRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.PersistentEntityResource;
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RepositoryRestController
@RequiredArgsConstructor
public class DrugController {

    private final DrugRepository repository;

    @RequestMapping(value = "/drugs/{id}")
    @ResponseBody
    public PersistentEntityResource getDrug(@PathVariable Long id,
                                            PersistentEntityResourceAssembler asm) {
        return asm.toFullResource(repository.findById(id));
    }
}
