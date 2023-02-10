package com.example.costummerservice.repository;

import com.example.costummerservice.entities.Costumer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CostummerRepository extends JpaRepository<Costumer,Long> {
}
