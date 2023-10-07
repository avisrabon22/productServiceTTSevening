package com.avijit.scalerproductproject.DTO.ProductDto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddProductDto {
    private String title;
    private double price;
    private String description;
    private String image;
    private String category;
}
