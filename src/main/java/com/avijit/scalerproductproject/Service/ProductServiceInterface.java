package com.avijit.scalerproductproject.Service;
//import com.avijit.scalerproductproject.DTO.ProdDto;
import com.avijit.scalerproductproject.Model.Product;

import java.util.List;

public interface ProductServiceInterface {
    List<Product> getAllProduct();

    Product getOneProduct(Long prodId);

    Product addNewProduct(
            String title,
            double price,
            String description,
            String image_url
    );

    String deleteProduct(Long prodId);

    String updateProduct(Long prodId);
}
