package com.avijit.scalerproductproject.Controller;

//import com.avijit.scalerproductproject.DTO.ProductDto.ProdDto;
//import com.avijit.scalerproductproject.DTO.ProductDto.ResponseOneProductDto;
import com.avijit.scalerproductproject.DTO.ProductDto.AddProductDto;
import com.avijit.scalerproductproject.DTO.ProductDto.ProdDto;
import com.avijit.scalerproductproject.Model.Product;
import com.avijit.scalerproductproject.Service.ProductServiceInterface;
import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

//import java.util.HashMap;
//import java.util.Map;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductServiceInterface productServiceInterface;

    public ProductController(ProductServiceInterface productServiceInterface) {
        this.productServiceInterface = productServiceInterface;
    }

    // *******************************************************************
    @GetMapping()
    public String getAllProduct() {
        return " getting all product";
    }

    // *****************************************************
    @GetMapping("/{prodId}")
    public ResponseEntity<Product> getOneProduct(@PathVariable("prodId") Long prodId) {
//             ResponseOneProductDto responseDto =new ResponseOneProductDto();
//             responseDto.setProduct(productServiceInterface.getOneProduct(prodId));

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add(
                "auth-token", "tui_bal_pabi"
        );

        ResponseEntity<Product> response;
        response = new ResponseEntity<>(
                productServiceInterface.getOneProduct(prodId),
                headers,
                HttpStatus.NOT_FOUND
        );
        return response;
    }

    // *************************************************************
    @PostMapping()
    public ResponseEntity<Product> addNewProduct(@RequestBody ProdDto product) {
        Product newProd = productServiceInterface.addNewProduct(
                product
        );
        ResponseEntity<Product> response;
        response = new ResponseEntity<>(newProd, HttpStatus.OK);

        return response;

    }
        // ****************************************************************

        @DeleteMapping("/{prodId}")
        public String deleteProduct (@PathVariable("prodId") Long prodId){
            return "Product deleted " + prodId;
        }
        // *****************************************************************
        @PutMapping("/{prodId}")
        public String updateProduct (@PathVariable("prodId") Long prodId){
            return "Product updated " + prodId;
        }
    }
