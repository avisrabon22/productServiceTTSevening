package com.avijit.scalerproductproject.Service;

import com.avijit.scalerproductproject.DTO.ProductDto.FakeStoreApiDto;
import com.avijit.scalerproductproject.DTO.ProductDto.ProdDto;
import com.avijit.scalerproductproject.Model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductServiceInterface {
    //***************************************************************************************
    List<Product> getAllProduct();

    Optional<Product> getOneProduct(Long prodId);

    Product addNewProduct(FakeStoreApiDto product);

    boolean deleteProduct(Long prodId);

    Product updateProduct(Product product,Long prodId);
}
