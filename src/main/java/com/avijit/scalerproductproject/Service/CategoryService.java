package com.avijit.scalerproductproject.Service;

import com.avijit.scalerproductproject.DTO.ProdDto;

public class CategoryService implements CategoryServiceInterface {
    @Override
    public String getAllCategory() {
        return " getting all product";
    }

    // *****************************************************


    @Override
    public String getOneCategory(Long prodId) {
        return "One product";
    }

    // *************************************************************

    @Override
    public String addNewCategory(ProdDto prodDto) {
        return prodDto.getTitle()+" added in database." ;
    }

    // ****************************************************************

    @Override
    public String deleteCategory(Long prodId) {
        return "Product deleted of " + prodId;
    }

    // *****************************************************************

    @Override
    public String updateCategory(Long prodId) {
        return "Product updated of " + prodId;
    }

}
