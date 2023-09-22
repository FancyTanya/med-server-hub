package com.github.mediservehub.domain.resourse;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

@Entity
@Data
public class Patient extends RepresentationModel<Patient> {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

}
