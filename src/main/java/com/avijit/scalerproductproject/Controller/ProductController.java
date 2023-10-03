package com.avijit.scalerproductproject.Controller;

import com.avijit.scalerproductproject.DTO.ProdDto;
import com.avijit.scalerproductproject.Service.ProductService;
import com.avijit.scalerproductproject.Service.ProductServiceInterface;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService){
        this.productService=productService;
    }

    // *******************************************************************
    @GetMapping("/products")
    public String getAllProduct() {
        return " getting all product";
    }
    // *****************************************************
     @GetMapping("/product/{prodId}")
    public String getOneProduct(@PathVariable("prodId") Long prodId) {
         return "One product " + prodId;
     }
    // *************************************************************
        @PostMapping("/addProduct")
    public String addNewProduct(@RequestBody ProdDto prodDto) {
        return prodDto.getTitle()+" added in database." ;
    }

    // ****************************************************************

@DeleteMapping("/deleteProd/{prodId}")
    public String deleteProduct(@PathVariable("prodId")Long prodId){
        return "Product deleted "+prodId;
    }
    // *****************************************************************8
@PutMapping("/updateProduct/{prodId}")
    public String updateProduct(@PathVariable("prodId") Long prodId){
        return "Product updated "+prodId;
    }
}
