package com.example.billingservice.service;

import com.example.billingservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "INVENTORY-SERVICE")
public interface ProductRestClient {
    @GetMapping (path = "/products/{id}")
     Product findProducyByid(@PathVariable  Long id);
    @GetMapping(path ="/products" )
    PagedModel<Product>  allProducts();

}
