package com.avijit.scalerproductproject.Service;

import com.avijit.scalerproductproject.DTO.ProductDto.ProdDto;
import com.avijit.scalerproductproject.Model.Product;

import java.util.List;

public interface ProductServiceInterface {
    List<Product> getAllProduct();

    Product getOneProduct(Long prodId);

    Product addNewProduct(ProdDto product);

    boolean deleteProduct(Long prodId);

    Product updateProduct(Product product,Long prodId);
}
