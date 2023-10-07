package com.avijit.scalerproductproject.DTO;

import com.avijit.scalerproductproject.Model.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdDto {
    private Long Id;
    private String title;
    private double price;
    private String category;
    private String description;
    private String image;
}
