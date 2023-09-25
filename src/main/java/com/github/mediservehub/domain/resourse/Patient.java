package com.github.mediservehub.domain.resourse;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.RepresentationModel;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Patient extends RepresentationModel<Patient> {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

}
