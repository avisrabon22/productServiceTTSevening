package com.avijit.scalerproductproject.Service.ThirdPartyApi;

import com.avijit.scalerproductproject.DTO.ProdDto;
import com.avijit.scalerproductproject.Service.CategoryServiceInterface;

public class FakeStoreCategoryService implements CategoryServiceInterface {
    @Override
    public String getAllCategory() {
        return null;
    }

    @Override
    public String getOneCategory(Long prodId) {
        return null;
    }

    @Override
    public String addNewCategory(ProdDto prodDto) {
        return null;
    }

    @Override
    public String deleteCategory(Long prodId) {
        return null;
    }

    @Override
    public String updateCategory(Long prodId) {
        return null;
    }
}
