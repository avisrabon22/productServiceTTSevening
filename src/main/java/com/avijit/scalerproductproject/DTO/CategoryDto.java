package com.avijit.scalerproductproject.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryDto {
    private String title;
    private double price;
    private String description;
    private String image_url;
    private String category;
}
