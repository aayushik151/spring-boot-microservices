package com.programming.product_service.service;

import com.programming.product_service.dto.ProductRequest;
import com.programming.product_service.dto.ProductResponse;
import com.programming.product_service.model.Product;
import com.programming.product_service.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public void createProduct(ProductRequest productRequest){
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();
        productRepository.save(product);
        log.info("Product {} is saved", product.getId());
    }

    public List<ProductResponse> getAllProducts(){
        List<Product> products = productRepository.findAll();
        return products.stream().map(this::mapToProductResponse).toList() ;
    }

    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }

//    public Product getProduct(String id) {
//        return productRepository.findById(id).orElse(null);
//    }

    public ProductResponse getProduct(String id){
        Product product = productRepository.findById(id).orElse(null);
        if(product!=null){
            return ProductResponse.builder()
                    .id(product.getId())
                    .name(product.getName())
                    .description(product.getDescription())
                    .price(product.getPrice())
                    .build();
        }
        else
            return null;
    }

    public void deleteProduct(String id){
        productRepository.findById(id).ifPresent(productRepository::delete);
    }
}
