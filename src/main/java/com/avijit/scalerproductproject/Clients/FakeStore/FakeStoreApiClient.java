package com.avijit.scalerproductproject.Clients.FakeStore;
import com.avijit.scalerproductproject.Model.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
@Component
public class FakeStoreApiClient {
    private final RestTemplateBuilder restTemplateBuilder;
    public FakeStoreApiClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    //*************************Customized Post entity for update method of product  *****************************************************************
    private  <T> ResponseEntity<T> requestForEntity(HttpMethod httpMethod, String url, @Nullable Object request, Class<T> responseType, Object... uriVariables) throws RestClientException {
        RestTemplate restTemplate = restTemplateBuilder.requestFactory(
                HttpComponentsClientHttpRequestFactory.class
        ).build();
        RequestCallback requestCallback = restTemplate.httpEntityCallback(request, responseType);
        ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate.responseEntityExtractor(responseType);
        return  restTemplate.execute(url, httpMethod, requestCallback, responseExtractor, uriVariables);
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
      return Optional.ofNullable(responseEntity.getBody());

    }
//**************************************************************************************************
    public FakeStoreApiDto addNewProduct(FakeStoreApiDto product){
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreApiDto> response = restTemplate.postForEntity(
                "https://fakestoreapi.com/products",
                product,
                FakeStoreApiDto.class
        );
        return response.getBody();
    }
//*************************************************************************************************
    public boolean deleteProduct(Long prodId){
        return false;
    }
//*************************************************************************************************
    public FakeStoreApiDto updateProduct(Product product, Long prodId){
        RestTemplate restTemplate = restTemplateBuilder.requestFactory(
                HttpComponentsClientHttpRequestFactory.class
        ).build();

        FakeStoreApiDto fakeStoreApiDto = new FakeStoreApiDto();
        fakeStoreApiDto.setDescription(product.getDescription());
        fakeStoreApiDto.setImage(product.getImageUrl());
        fakeStoreApiDto.setPrice(product.getPrice());
        fakeStoreApiDto.setTitle(product.getTitle());
        fakeStoreApiDto.setCategory(product.getCategory().getName());

        ResponseEntity<FakeStoreApiDto> fakeStoreProductDtoResponseEntity = requestForEntity(
                HttpMethod.PATCH,
                "https://fakestoreapi.com/products/{id}",
                fakeStoreApiDto,
                FakeStoreApiDto.class,
                prodId
        );
        return fakeStoreProductDtoResponseEntity.getBody();

//        if (fakeStoreProductDtoResponseEntity.getHeaders())
//        FakeStoreApiDto fakeStoreProductDtoResponse = restTemplate.patchForObject(
//                "https://fakestoreapi.com/products/{id}",
//                fakeStoreApiDto,
//                FakeStoreApiDto.class,
//                prodId
//        );
    }
}
