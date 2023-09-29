package com.avijit.scalerproductproject.Controller;

import com.avijit.scalerproductproject.DTO.ProdDto;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
    // *******************************************************************
    @GetMapping("/products")
    public String getAllProduct() {
        return " getting all product";
    }

    // *****************************************************

    @GetMapping("/product/{prodId}")
    public String getOneProduct(@PathVariable("prodId") Long prodId) {
        return "One product";
    }

    // *************************************************************
    @PostMapping("/addProduct/")
    public String addNewProduct(@RequestBody ProdDto prodDto) {
        return "Product added of " + prodDto;
    }

    // ****************************************************************
    @DeleteMapping("/deletProd/{prodId}")
    public String deleteProduct(@PathVariable("prodId") Long prodId) {
        return "Product deleted of " + prodId;
    }

    // *****************************************************************
    @PutMapping("/updateProduct/{prodId}")
    public String updateProduct(@PathVariable("prodId") Long prodId) {
        return "Product updated of " + prodId;
    }
}
