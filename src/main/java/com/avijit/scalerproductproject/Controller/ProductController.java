package com.avijit.scalerproductproject.Controller;

<<<<<<< HEAD
=======
import com.avijit.scalerproductproject.DTO.ProdDto;
>>>>>>> 618c921ebb37ead0c71f0377cd7c83ee8af5444c
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
    // *******************************************************************
    @GetMapping("/products")
    public String getAllProduct() {
        return " getting all product";
    }

    // *****************************************************

<<<<<<< HEAD
     @GetMapping("/product/{prodId}")
    public String getOneProduct(@PathVariable("prodId") Long prodId){
        return "One product "+prodId;
=======
    @GetMapping("/product/{prodId}")
    public String getOneProduct(@PathVariable("prodId") Long prodId) {
        return "One product";
>>>>>>> 618c921ebb37ead0c71f0377cd7c83ee8af5444c
    }

    // *************************************************************
        @PostMapping("/addProduct")
    public String addNewProduct(@RequestBody ProdDto prodDto) {
        return prodDto.getTitle()+" added in database." ;
    }

    // ****************************************************************
<<<<<<< HEAD
@DeleteMapping("/deletProd/{prodId}")
    public String deleteProduct(@PathVariable("prodId")Long prodId){
        return "Product deleted "+prodId;
    }
    // *****************************************************************8
@PutMapping("/updateProduct/{prodId}")
    public String updateProduct(@PathVariable("prodId") Long prodId){
        return "Product updated "+prodId;
=======
    @DeleteMapping("/deletProd/{prodId}")
    public String deleteProduct(@PathVariable("prodId") Long prodId) {
        return "Product deleted of " + prodId;
    }

    // *****************************************************************
    @PutMapping("/updateProduct/{prodId}")
    public String updateProduct(@PathVariable("prodId") Long prodId) {
        return "Product updated of " + prodId;
>>>>>>> 618c921ebb37ead0c71f0377cd7c83ee8af5444c
    }
}
