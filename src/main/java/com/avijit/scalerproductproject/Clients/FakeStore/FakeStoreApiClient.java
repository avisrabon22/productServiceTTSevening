package com.avijit.scalerproductproject.Clients.FakeStore;
import com.avijit.scalerproductproject.Model.Category;
import com.avijit.scalerproductproject.Model.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Optional;
@Component
public class FakeStoreApiClient {
    private final RestTemplateBuilder restTemplateBuilder;
    public FakeStoreApiClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    //****************To avoid duplicate code make the function for FakeStoreproductDto to Product***********************************************************************
    private Product  convertFakstoreProductDtoToProduct(FakeStoreApiDto fakeStoreApiDto){
        Product product = new Product();
        product.setId(fakeStoreApiDto.getId());
        product.setTitle(fakeStoreApiDto.getTitle());
        product.setPrice(fakeStoreApiDto.getPrice());
        Category category = new Category();
        category.setName(fakeStoreApiDto.getCategory());
        product.setCategory(category);
        product.setImageUrl(fakeStoreApiDto.getImage());

        return  product;
    }
//*****************************************************************************************
    public List<FakeStoreApiDto> getAllProduct(){
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreApiDto[]> apiProdList = restTemplate.getForEntity(
                "https://fakestoreapi.com/products",
                FakeStoreApiDto[].class
        );
        return null;
    }
//**********************************************************************************************
  public Optional<Product> getOneProduct(Long prodId){
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreApiDto> responseEntity =restTemplate.getForEntity(
                "https://fakestoreapi.com/products/{id}",
                FakeStoreApiDto.class,
                prodId);

        FakeStoreApiDto fakeStoreApiDto = responseEntity.getBody();
        if(fakeStoreApiDto==null){
            return Optional.empty();
        }
        return Optional.of(convertFakstoreProductDtoToProduct(responseEntity.getBody()));
    }
//**************************************************************************************************
    Product addNewProduct(FakeStoreApiDto product){
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreApiDto> response=restTemplate.postForEntity(
                "https://fakestoreapi.com/products",
                fakeStoreApiDto,
                FakeStoreApiDto.class
        );
        FakeStoreApiDto prodDto = response.getBody();

        return convertFakstoreProductDtoToProduct(prodDto);
    }
//*************************************************************************************************
    public boolean deleteProduct(Long prodId){
        return false;
    }
//*************************************************************************************************
    public Product updateProduct(Product product,Long prodId){
        return null;
    }
}
