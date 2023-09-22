package com.github.mediservehub.domain.resourse;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Drug {
    @Id
    @GeneratedValue
    private Long id;

    private String title;

    @ManyToOne
    @JoinColumn(name = "drug_id")
    private Stock stock;

}
