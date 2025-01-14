package dev.naman.productservicettsevening.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product extends BaseModel {
    private String title;
    private double price;
    private String description;
    // P : C
    // 1 -> 1
    // m <- 1
    // M <-> 1
    @ManyToOne
    private Category category;
    private String imageUrl;
}
