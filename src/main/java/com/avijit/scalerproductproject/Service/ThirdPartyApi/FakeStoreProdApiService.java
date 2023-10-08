package com.avijit.scalerproductproject.Service.ThirdPartyApi;

import com.avijit.scalerproductproject.DTO.ProductDto.ProdDto;
import com.avijit.scalerproductproject.Model.Category;
import com.avijit.scalerproductproject.Model.Product;
import com.avijit.scalerproductproject.Service.ProductServiceInterface;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.*;

@Service
public class FakeStoreProdApiService implements ProductServiceInterface {
    private final RestTemplateBuilder restTemplateBuilder;
    //***************************************************************************************
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
        product.setImageUrl(prodDto.getImage());

        return product;
    }
//***************************************************************************************
    @Override
    public Product addNewProduct(ProdDto product) {
    RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProdDto> response=restTemplate.postForEntity(
                "https://fakestoreapi.com/products",
                product,
                ProdDto.class
        );

        ProdDto prodDto = response.getBody();

        Product currentProd = new Product();
        assert prodDto != null;
        currentProd.setId(prodDto.getId());
        currentProd.setTitle(prodDto.getTitle());
        currentProd.setPrice(prodDto.getPrice());
        Category category = new Category();
        category.setName(prodDto.getCategory());
        currentProd.setCategory(category);
        currentProd.setImageUrl(prodDto.getImage());

        return currentProd;
    }
//**************************************************************************************
@Override
public List<Product> getAllProduct() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<List> apiProdList = restTemplate.getForEntity(
                "https://fakestoreapi.com/products",
                List.class
        );
     List<Product> productList = new ArrayList<>();

     for(Object object:apiProdList.getBody()){
         ProdDto prodDto = (ProdDto) object;
         Product product = new Product();
         product.setId(prodDto.getId());
         product.setTitle(prodDto.getTitle());
         product.setPrice(prodDto.getPrice());
         Category category = new Category();
         category.setName(prodDto.getCategory());
         product.setCategory(category);
         product.setImageUrl(prodDto.getImage());
        productList.add(product);
     }
    return productList;
}
//***************************************************************************************
    @Override
    public boolean deleteProduct(Long prodId) {
        return false;
    }
//***********************************************************************************
    @Override
    public Product updateProduct(Product product,Long prodId) {
        return null;
    }
}
