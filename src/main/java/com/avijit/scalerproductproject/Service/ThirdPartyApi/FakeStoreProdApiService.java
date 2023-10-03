package com.avijit.scalerproductproject.Service.ThirdPartyApi;

import com.avijit.scalerproductproject.DTO.ProdDto;
import com.avijit.scalerproductproject.Service.ProductServiceInterface;

public class FakeStoreProdApiService implements ProductServiceInterface {
    @Override
    public String getAllProduct() {
        return null;
    }

    @Override
    public String getOneProduct(Long prodId) {
        return null;
    }

    @Override
    public String addNewProduct(ProdDto prodDto) {
        return null;
    }

    @Override
    public String deleteProduct(Long prodId) {
        return null;
    }

    @Override
    public String updateProduct(Long prodId) {
        return null;
    }
}
