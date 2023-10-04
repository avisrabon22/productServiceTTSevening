package com.avijit.scalerproductproject.Service;

import com.avijit.scalerproductproject.DTO.ProdDto;
import com.avijit.scalerproductproject.Model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements ProductServiceInterface {

    @Override
    public List<Product> getAllProduct() {
        return null;
    }

    @Override
    public Product getOneProduct(Long prodId) {
        return null;
    }

    @Override
    public Product addNewProduct(Product product) {
        return null;
    }

    @Override
    public boolean deleteProduct(Long prodId) {
        return false;
    }

    @Override
    public Product updateProduct(Long prodId) {
        return null;
    }
}
