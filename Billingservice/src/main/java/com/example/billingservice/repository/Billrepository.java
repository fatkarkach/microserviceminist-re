package com.example.billingservice.repository;

import com.example.billingservice.entities.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Billrepository extends JpaRepository<Bill,Long> {
}
