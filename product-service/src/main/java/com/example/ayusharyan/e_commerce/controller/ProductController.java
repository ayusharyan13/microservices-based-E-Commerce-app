package com.example.ayusharyan.e_commerce.controller;


import com.example.ayusharyan.e_commerce.dto.ProductRequest;
import com.example.ayusharyan.e_commerce.dto.ProductResponse;
import com.example.ayusharyan.e_commerce.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product")
public class ProductController {

    // inject ProductService;
    private final ProductService productService;
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest productRequest){  // ProductRequest is dto
        // processing of business logic should be done in service layer
        productService.createProduct(productRequest);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts() {
        return productService.getAllProducts();
    }
}
