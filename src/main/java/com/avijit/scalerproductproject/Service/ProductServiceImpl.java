package com.avijit.scalerproductproject.Service;

import com.avijit.scalerproductproject.DTO.ProdDto;
import org.springframework.web.bind.annotation.*;

public class ProductServiceImpl implements ProductServiceInterface {


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
