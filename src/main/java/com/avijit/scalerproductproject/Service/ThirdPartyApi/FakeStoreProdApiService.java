package com.avijit.scalerproductproject.Service.ThirdPartyApi;

import com.avijit.scalerproductproject.DTO.ProductDto.AddProductDto;
import com.avijit.scalerproductproject.DTO.ProductDto.ProdDto;
import com.avijit.scalerproductproject.Model.Category;
import com.avijit.scalerproductproject.Model.Product;
import com.avijit.scalerproductproject.Service.ProductServiceInterface;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.*;

@Service
public class FakeStoreProdApiService implements ProductServiceInterface {
    private final RestTemplateBuilder restTemplateBuilder;
    //***************************************************************************************
    public FakeStoreProdApiService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder=restTemplateBuilder;
    }
//*************************Customized Post entity for update method of product  *****************************************************************
private  <T> ResponseEntity<T> requestForEntity(HttpMethod httpMethod,String url, @Nullable Object request, Class<T> responseType, Object... uriVariables) throws RestClientException {
    RestTemplate restTemplate = restTemplateBuilder.build();
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
        ResponseEntity<ProdDto[]> apiProdList = restTemplate.getForEntity(
                "https://fakestoreapi.com/products",
                ProdDto[].class
        );
        List<Product> productList = new ArrayList<>();

     for(ProdDto prodDto:apiProdList.getBody()){
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
        AddProductDto addProductDto = new AddProductDto();
        addProductDto.setTitle(product.getTitle());
        addProductDto.setPrice(product.getPrice());
        addProductDto.setDescription(product.getDescription());
        addProductDto.setCategory(product.getCategory().getName());
        addProductDto.setImage(product.getImageUrl());

        RestTemplate restTemplate = restTemplateBuilder.build();
         ResponseEntity<AddProductDto> productDtoResponseEntity =requestForEntity(
                 HttpMethod.PATCH,
                 "https://fakestoreapi.com/products/{id}",
                 addProductDto,
                 AddProductDto.class,
                 prodId
         );

        return null;
    }
}
