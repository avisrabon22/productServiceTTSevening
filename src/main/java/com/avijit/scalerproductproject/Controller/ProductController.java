package com.avijit.scalerproductproject.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
@GetMapping("/products")
    public String getAllProduct(){
        return " getting all product";
    }

    public String getOneProduct(){
        return "One product";
    }

    public String addNewProduct(){
        return "Product added";
    }
    public String deleteProduct(){
        return "Product deleted";
    }

    public String updateProduct(){
        return "Product updated";
    }
}
