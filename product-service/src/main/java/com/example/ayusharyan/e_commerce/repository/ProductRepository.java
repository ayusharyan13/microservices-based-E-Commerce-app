package com.example.ayusharyan.e_commerce.repository;

import com.example.ayusharyan.e_commerce.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product,String> {

}
