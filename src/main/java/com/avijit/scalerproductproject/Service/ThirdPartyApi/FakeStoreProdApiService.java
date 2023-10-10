package com.avijit.scalerproductproject.Service.ThirdPartyApi;

import com.avijit.scalerproductproject.DTO.ProductDto.FakeStoreApiDto;
import com.avijit.scalerproductproject.DTO.ProductDto.ProdDto;
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
public class FakeStoreProdApiService implements ProductServiceInterface {
    private final RestTemplateBuilder restTemplateBuilder;
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
//******************************************************************************************
    public FakeStoreProdApiService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder=restTemplateBuilder;
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
    public Product addNewProduct(FakeStoreApiDto fakeStoreApiDto) {
    RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreApiDto> response=restTemplate.postForEntity(
                "https://fakestoreapi.com/products",
                fakeStoreApiDto,
                FakeStoreApiDto.class
        );
        FakeStoreApiDto prodDto = response.getBody();

        return convertFakstoreProductDtoToProduct(prodDto);
    }
//**************************************************************************************
@Override
public List<Product> getAllProduct() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreApiDto[]> apiProdList = restTemplate.getForEntity(
                "https://fakestoreapi.com/products",
                FakeStoreApiDto[].class
        );
        List<Product> productList = new ArrayList<>();

     for(FakeStoreApiDto fakeStoreApiDto:apiProdList.getBody()){
         productList.add(convertFakstoreProductDtoToProduct(fakeStoreApiDto));
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
                 HttpMethod.PUT,
                 "https://fakestoreapi.com/products/{id}",
                 fakeStoreApiDto,
                 FakeStoreApiDto.class,
                 prodId
         );
        return convertFakstoreProductDtoToProduct(productDtoResponseEntity.getBody());
    }
}
