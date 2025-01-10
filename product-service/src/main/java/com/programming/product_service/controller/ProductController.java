package com.programming.product_service.controller;

import com.programming.product_service.dto.ProductRequest;
import com.programming.product_service.dto.ProductResponse;
import com.programming.product_service.model.Product;
import com.programming.product_service.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService    productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest productRequest){
        productService.createProduct(productRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/id")
    @ResponseStatus(HttpStatus.OK)
    public ProductResponse getProduct(@RequestParam String id){
        System.out.println("id " + id);
        return productService.getProduct(id);
    }

    @DeleteMapping("/id")
    @ResponseStatus(HttpStatus.OK)
    public void deleteProduct(@RequestParam String id){
        productService.deleteProduct(id);
    }

//    @GetMapping("/id")
//    @ResponseStatus(HttpStatus.OK)
//    public Product getProduct(@RequestParam String id){
//        System.out.println("id " + id);
//        return productService.getProduct(id);
//    }

}
