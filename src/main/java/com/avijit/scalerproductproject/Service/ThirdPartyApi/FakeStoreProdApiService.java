package com.avijit.scalerproductproject.Service.ThirdPartyApi;

import com.avijit.scalerproductproject.DTO.ProdDto;
import com.avijit.scalerproductproject.Model.Category;
import com.avijit.scalerproductproject.Model.Product;
import com.avijit.scalerproductproject.Service.ProductServiceInterface;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FakeStoreProdApiService implements ProductServiceInterface {
    private final RestTemplateBuilder restTemplateBuilder;

    public FakeStoreProdApiService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder=restTemplateBuilder;
    }

//******************************************************************************************
    @Override
    public Product getOneProduct(Long prodId) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProdDto> responseEntity =restTemplate.getForEntity("https://fakestoreapi.com/products/{id}",ProdDto.class,prodId);
        ProdDto prodDto = responseEntity.getBody();

        Product product = new Product();
        assert prodDto != null;
        product.setId(prodDto.getId());
        product.setTitle(prodDto.getTitle());
        product.setPrice(prodDto.getPrice());
        Category category = new Category();
        category.setName(prodDto.getCategory());
        product.setCategory(category);
        product.setImageUrl(prodDto.getImage_url());

        return product;
    }
//***************************************************************************************
    @Override
    public Product addNewProduct(Product product) {

        return null;
    }
//**************************************************************************************
    @Override
    public boolean deleteProduct(Long prodId) {
        return false;
    }
//***********************************************************************************
    @Override
    public Product updateProduct(Product product,Long prodId) {
        return null;
    }
//***************************************************************************************
    @Override
    public List<Product> getAllProduct() {


        return null;
    }

}
