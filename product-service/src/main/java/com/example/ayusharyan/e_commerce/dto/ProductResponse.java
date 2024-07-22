package com.example.ayusharyan.e_commerce.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponse {
    private String id;
    private String name;
    private String description;
    private BigDecimal price;

}


/*
       why separate ProductResponse created:

       *** Ideally we should not expose model entities:-

       suppose : you want to change the original model of Product to add new properties
       that u don't want to expose to outside world:


 */
