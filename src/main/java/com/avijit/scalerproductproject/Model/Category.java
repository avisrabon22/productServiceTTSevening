package com.avijit.scalerproductproject.Model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Category extends BaseModel{
    private String name;
    private List<Product> products;
    private  String description;
}
