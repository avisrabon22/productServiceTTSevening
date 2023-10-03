package com.avijit.scalerproductproject.Controller;

import com.avijit.scalerproductproject.DTO.ProdDto;
import org.springframework.web.bind.annotation.*;

@RestController
public class CategoryController {

    @GetMapping("/category/{categoryId}")
    public String getAllCategory(){
        return "All category";
    }
    // *****************************************************
    @GetMapping("/category/{categoryId}")
    public String getOneCategory(@PathVariable("categoryId") Long categoryId) {
        return "One Category " + categoryId;
    }
    // *************************************************************
    @PostMapping("/addCategory")
    public String addNewCategory(@RequestBody ProdDto categoryDto) {
        return categoryDto.getTitle()+" added in database." ;
    }

    // ****************************************************************

    @DeleteMapping("/deleteProd/{categoryId}")
    public String deleteCategory(@PathVariable("categoryId")Long categoryId){

        return "Category deleted "+categoryId;
    }
    // *****************************************************************8
    @PutMapping("/updateCategory/{categoryId}")
    public String updateCategory(@PathVariable("prodId") Long categoryId){
        return "Category updated "+categoryId;
    }

}
