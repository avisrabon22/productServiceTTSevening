package com.avijit.scalerproductproject.Clients.FakeStore;
import com.avijit.scalerproductproject.Model.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
@Component
public class FakeStoreApiClient {
    private final RestTemplateBuilder restTemplateBuilder;
    public FakeStoreApiClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }


//*****************************************************************************************
    public List<FakeStoreApiDto> getAllProduct(){
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreApiDto[]> apiProdList = restTemplate.getForEntity(
                "https://fakestoreapi.com/products",
                FakeStoreApiDto[].class
        );
        return List.of(apiProdList.getBody());
    }
//**********************************************************************************************
  public Optional<FakeStoreApiDto> getOneProduct(Long prodId){
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreApiDto> responseEntity =restTemplate.getForEntity(
                "https://fakestoreapi.com/products/{id}",
                FakeStoreApiDto.class,
                prodId);

        FakeStoreApiDto fakeStoreApiDto = responseEntity.getBody();
        if(fakeStoreApiDto==null){
            return Optional.empty();
        }
        return Optional.ofNullable(responseEntity.getBody());
    }
//**************************************************************************************************
    Product addNewProduct(FakeStoreApiDto product){
      return null;
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
