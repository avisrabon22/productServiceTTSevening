package com.avijit.scalerproductproject.Controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
@GetMapping("/products")
    public String getAllProduct(){
        return " getting all product";
    }
     @GetMapping("/product")
    public String getOneProduct(){
        return "One product";
    }
@PostMapping("/addProduct")
    public String addNewProduct(){
        return "Product added";
    }
@DeleteMapping("/deletProd")
    public String deleteProduct(){
        return "Product deleted";
    }
@PutMapping("/updateProduct")
    public String updateProduct(){
        return "Product updated";
    }
}
