package com.avijit.scalerproductproject.Service.ThirdPartyApiImpl;
import com.avijit.scalerproductproject.Clients.FakeStore.FakeStoreApiClient;
import com.avijit.scalerproductproject.Clients.FakeStore.FakeStoreApiDto;
import com.avijit.scalerproductproject.Model.Category;
import com.avijit.scalerproductproject.Model.Product;
import com.avijit.scalerproductproject.Service.ProductServiceInterface;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class FakeStoreProdApiServiceImpl implements ProductServiceInterface {
    private final FakeStoreApiClient fakeStoreApiClient;
    private final RestTemplateBuilder restTemplateBuilder;

      public FakeStoreProdApiServiceImpl(FakeStoreApiClient fakeStoreApiClient,RestTemplateBuilder restTemplateBuilder){
          this.fakeStoreApiClient=fakeStoreApiClient;
          this.restTemplateBuilder = restTemplateBuilder;
      }

    //****************To avoid duplicate code make the function for FakeStoreproductDto to Product***********************************************************************
    private Product  convertFakstoreProductDtoToProduct(FakeStoreApiDto fakeStoreApiDto){
        Product product = new Product();
        product.setId(fakeStoreApiDto.getId());
        product.setProductName(fakeStoreApiDto.getTitle());
        product.setPrice(fakeStoreApiDto.getPrice());
        Category category = new Category();
        category.setName(fakeStoreApiDto.getCategory());
        product.setCategory(category);
        product.setImageUrl(fakeStoreApiDto.getImage());

        return  product;
    }
//   ********************************************************************************
    @Override
    public Optional<Product> getOneProduct(Long prodId) {
          Optional<FakeStoreApiDto> clientDto =fakeStoreApiClient.getOneProduct(prodId);
        return clientDto.map(this::convertFakstoreProductDtoToProduct);

        //Product product = new Product();
//         assert prodDto != null;
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
    return convertFakstoreProductDtoToProduct(fakeStoreApiClient.addNewProduct(fakeStoreApiDto));
    }
//**************************************************************************************
@Override
public List<Product> getAllProduct() {
        List<FakeStoreApiDto> fakeStoreProduct=fakeStoreApiClient.getAllProduct();
        List<Product> productList = new ArrayList<>();

     for(FakeStoreApiDto fakeStoreApiDto:fakeStoreProduct){
         productList.add(convertFakstoreProductDtoToProduct(fakeStoreApiDto));
     }
    return productList;
}
//***************************************************************************************
    @Override
    public String deleteProduct(Long prodId) {

        return fakeStoreApiClient.deleteProduct(prodId);
    }
//***********************************************************************************
    @Override
    public Product updateProduct(Product product,Long prodId) {
          return convertFakstoreProductDtoToProduct(fakeStoreApiClient.updateProduct(product,prodId));
    }
}
