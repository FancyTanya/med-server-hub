package com.github.mediservehub.domain.resourse;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Entity
@Data
@ToString
public class Stock {
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "stock")
    private List<Drug> drugsList;

}
