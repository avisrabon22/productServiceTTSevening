package com.avijit.scalerproductproject.Dao;

import com.avijit.scalerproductproject.DTO.ProductDto.ProdDto;
import com.avijit.scalerproductproject.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepo  extends JpaRepository<Product,Long>{

    Product save(Product product);
    Product findProductById(Long id);
}
