package com.avijit.scalerproductproject.Service;
//import com.avijit.scalerproductproject.DTO.ProdDto;
import com.avijit.scalerproductproject.DTO.ProdDto;
import com.avijit.scalerproductproject.Model.Product;

import java.util.List;

public interface ProductServiceInterface {
    List<Product> getAllProduct();

    Product getOneProduct(Long prodId);

    Product addNewProduct(Product product);

    boolean deleteProduct(Long prodId);

    Product updateProduct(Product product,Long prodId);
}
