package com.avijit.scalerproductproject.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel {
    private String productName;
    private Double price;
    private String description;
    @ManyToOne
    private Category category;
    private String imageUrl;
}
