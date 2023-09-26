package com.avijit.scalerproductproject.Controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
// *******************************************************************
@GetMapping("/products")
    public String getAllProduct(){
        return " getting all product";
    }

    // *****************************************************

     @GetMapping("/product/{prodId}")
    public String getOneProduct(@PathVariable("prodId") Long prodId){
        return "One product";
    }
    // *************************************************************
@PostMapping("/addProduct/")
    public String addNewProduct(@PathVariable("prodId") Long prodId){
        return "Product added";
    }
    // ****************************************************************
@DeleteMapping("/deletProd/{prodId}")
    public String deleteProduct(@PathVariable("prodId" Long prodId)){
        return "Product deleted";
    }
    // *****************************************************************8
@PutMapping("/updateProduct/{prodId}")
    public String updateProduct(@PathVariable("prodId" Long prodId){
        return "Product updated";
    }
}
