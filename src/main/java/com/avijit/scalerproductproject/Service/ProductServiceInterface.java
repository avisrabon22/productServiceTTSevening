package com.avijit.scalerproductproject.Service;

import com.avijit.scalerproductproject.DTO.ProdDto;

public interface ProductServiceInterface {
    String getAllProduct();

    String getOneProduct(Long prodId);

    String addNewProduct(ProdDto prodDto);

    String deleteProduct(Long prodId);

    String updateProduct(Long prodId);
}
