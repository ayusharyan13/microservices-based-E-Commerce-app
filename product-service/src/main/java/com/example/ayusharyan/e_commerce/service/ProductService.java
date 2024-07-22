package com.example.ayusharyan.e_commerce.service;
import com.example.ayusharyan.e_commerce.dto.ProductRequest;
import com.example.ayusharyan.e_commerce.dto.ProductResponse;
import com.example.ayusharyan.e_commerce.model.Product;
import com.example.ayusharyan.e_commerce.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository; // to save this in to db access the productRepo::
    // RequiredArgsConstructor used for this purpose to generate constructor : to access productRepo --> inject in ProductService class


    public void createProduct(ProductRequest productRequest) {
        // mapping of Product to incoming ProductRequest
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();  // build will create object of type Product with all the request details

        // to save this in to db access the productRepo:: to access productRepo --> inject in ProductService class
        productRepository.save(product);
        log.info("Product {} is saved", product.getId());
    }

    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(this::mapToProductResponse).toList();
    }

    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
