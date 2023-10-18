package com.avijit.scalerproductproject.Controller;

import com.avijit.scalerproductproject.Clients.FakeStore.FakeStoreApiDto;
import com.avijit.scalerproductproject.DTO.ProductDto.ProdDto;
import com.avijit.scalerproductproject.Exception.NoDataFound;
import com.avijit.scalerproductproject.Model.Category;
import com.avijit.scalerproductproject.Model.Product;
import com.avijit.scalerproductproject.Service.ProductServiceInterface;
import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductServiceInterface productServiceInterface;
    public ProductController(ProductServiceInterface productServiceInterface) {
        this.productServiceInterface = productServiceInterface;
    }

    // *******************************************************************
    @GetMapping()
    public List<Product> getAllProduct() {
        return productServiceInterface.getAllProduct();
    }

    // *****************************************************
    @GetMapping("/{prodId}")
    public ResponseEntity<Product> getOneProduct(@PathVariable("prodId") Long prodId) throws NoDataFound {
//             ResponseOneProductDto responseDto =new ResponseOneProductDto();
//             responseDto.setProduct(productServiceInterface.getOneProduct(prodId));

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add(
                "auth-token", "tui_bal_pi"
        );
        Optional<Product> productOptional= productServiceInterface.getOneProduct(prodId);
        if(productOptional.isEmpty())
        {
            throw new NoDataFound("No such Id found in database for: "+prodId);
        }

        ResponseEntity<Product> response;
        response = new ResponseEntity<>(
                productServiceInterface.getOneProduct(prodId).get(),
                headers,
                HttpStatus.NOT_FOUND
        );
        return response;
    }

    // *************************************************************
    @PostMapping()
    public ResponseEntity<Product> addNewProduct(@RequestBody FakeStoreApiDto product) {
        Product newProd = productServiceInterface.addNewProduct(
                product
        );
        ResponseEntity<Product> response;
        response = new ResponseEntity<>(newProd, HttpStatus.OK);

        return response;
    }

        // *****************************************************************
        @PatchMapping("/{prodId}")
        public Product updateProduct (@PathVariable("prodId") Long prodId , @RequestBody ProdDto prodDto){
        Product product = new Product();
        product.setProductName(prodDto.getTitle());
        product.setPrice(prodDto.getPrice());
        product.setDescription(prodDto.getDescription());
        product.setCategory(new Category());
        product.getCategory().setName(prodDto.getCategory());
        product.setImageUrl(prodDto.getImage());

        return productServiceInterface.updateProduct(product, prodId);
        }
    // ****************************************************************

    @DeleteMapping("/{prodId}")
    public String deleteProduct (@PathVariable("prodId") Long prodId){

        return productServiceInterface.deleteProduct(prodId);
    }

    }