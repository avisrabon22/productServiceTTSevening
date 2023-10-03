package com.avijit.scalerproductproject.Service;

import com.avijit.scalerproductproject.DTO.ProdDto;

public interface CategoryServiceInterface {
    String getAllCategory();

    String getOneCategory(Long prodId);

    String addNewCategory(ProdDto prodDto);

    String deleteCategory(Long prodId);

    String updateCategory(Long prodId);
}
