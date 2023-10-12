package com.avijit.scalerproductproject.Service.ThirdPartyApiImpl;

import com.avijit.scalerproductproject.Clients.FakeStore.FakeStoreApiClient;
import com.avijit.scalerproductproject.Clients.FakeStore.FakeStoreApiDto;
import com.avijit.scalerproductproject.Model.Category;
import com.avijit.scalerproductproject.Model.Product;
import com.avijit.scalerproductproject.Service.ProductServiceInterface;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.*;
@Service
public class FakeStoreProdApiServiceImpl implements ProductServiceInterface {
    private FakeStoreApiClient fakeStoreApiClient;
      public FakeStoreProdApiServiceImpl(FakeStoreApiClient fakeStoreApiClient){
          this.fakeStoreApiClient=fakeStoreApiClient;
      }
//*************************Customized Post entity for update method of product  *****************************************************************
private  <T> ResponseEntity<T> requestForEntity(HttpMethod httpMethod,String url, @Nullable Object request, Class<T> responseType, Object... uriVariables) throws RestClientException {
    RestTemplate restTemplate = restTemplateBuilder.requestFactory(
            HttpComponentsClientHttpRequestFactory.class
    ).build();
        RequestCallback requestCallback = restTemplate.httpEntityCallback(request, responseType);
    ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate.responseEntityExtractor(responseType);
    return  restTemplate.execute(url, httpMethod, requestCallback, responseExtractor, uriVariables);
}
//   ********************************************************************************
    @Override
    public Optional<Product> getOneProduct(Long prodId) {
        return fakeStoreApiClient.getOneProduct(prodId);
//        Product product = new Product();
//        assert prodDto != null;
//        product.setId(prodDto.getId());
//        product.setTitle(prodDto.getTitle());
//        product.setPrice(prodDto.getPrice());
//        Category category = new Category();
//        category.setName(prodDto.getCategory());
//        product.setCategory(category);
//        product.setImageUrl(prodDto.getImage());
//
//        return product;
    }
    //***************************************************************************************
    @Override
    public Product addNewProduct(FakeStoreApiDto fakeStoreApiDto) {

    }
//**************************************************************************************
@Override
public List<FakeStoreApiDto> getAllProduct() {
        List<Product> fakeStoreProduct=fakeStoreApiClient.getAllProduct();
        List<Product> productList = new ArrayList<>();

     for(FakeStoreApiDto fakeStoreApiDto:fakeStoreProduct){
         productList.add();
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
        RestTemplate restTemplate = restTemplateBuilder.build();

             FakeStoreApiDto fakeStoreApiDto = new FakeStoreApiDto();
             fakeStoreApiDto.setTitle(product.getTitle());
             fakeStoreApiDto.setPrice(product.getPrice());
             fakeStoreApiDto.setDescription(product.getDescription());
             fakeStoreApiDto.setImage(product.getImageUrl());
             fakeStoreApiDto.setCategory(product.getCategory().getName());


         ResponseEntity<FakeStoreApiDto> productDtoResponseEntity =requestForEntity(
                 HttpMethod.PATCH,
                 "https://fakestoreapi.com/products/{id}",
                 fakeStoreApiDto,
                 FakeStoreApiDto.class,
                 prodId
         );
        return convertFakstoreProductDtoToProduct(productDtoResponseEntity.getBody());
    }
}
