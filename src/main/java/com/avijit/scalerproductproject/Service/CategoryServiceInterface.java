package com.avijit.scalerproductproject.Service;

import com.avijit.scalerproductproject.DTO.ProdDto;

public interface  CategoryServiceInterface {
    String getAllCategory();

    String getOneCategory(Long prodId);

    String addNewCategory(
            String title,
            double price,
            String description,
            String image_url,
            String category
    );

    String deleteCategory(Long prodId);

    String updateCategory(Long prodId);
}
