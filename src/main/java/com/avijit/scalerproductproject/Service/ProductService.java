package com.avijit.scalerproductproject.Service;

import com.avijit.scalerproductproject.DTO.ProdDto;

<<<<<<< HEAD:src/main/java/com/avijit/scalerproductproject/Service/ProductServiceImpl.java
public class ProductServiceImpl implements ProductServiceInterface {
=======
public class ProductService implements ProductServiceInterface {


>>>>>>> 946e6090a14978105661baf08003fc578e014f34:src/main/java/com/avijit/scalerproductproject/Service/ProductService.java
    @Override
    public String getAllProduct() {
        return " getting all product";
    }

    // *****************************************************
    @Override
    public String getOneProduct(Long prodId) {
        return "One product";
    }
    // *************************************************************
    @Override
    public String addNewProduct(ProdDto prodDto) {
        return prodDto.getTitle()+" added in database." ;
    }
    // ****************************************************************
    @Override
    public String deleteProduct(Long prodId) {
        return "Product deleted of " + prodId;
    }
    // *****************************************************************
    @Override
    public String updateProduct(Long prodId) {
        return "Product updated of " + prodId;
    }
}
