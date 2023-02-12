package com.example.billingservice.repository;

import com.example.billingservice.entities.Productsitem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductitemRepository extends JpaRepository<Productsitem,Long> {
}
