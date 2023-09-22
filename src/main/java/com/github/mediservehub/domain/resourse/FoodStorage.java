package com.github.mediservehub.domain.resourse;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Entity
@Data
@ToString
public class FoodStorage {
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "foodStorage")
    private List<Food> foodList;
}
