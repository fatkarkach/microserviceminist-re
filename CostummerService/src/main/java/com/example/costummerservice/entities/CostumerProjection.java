package com.example.costummerservice.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "fullcostumer",types = Costumer.class)
public interface CostumerProjection {
    public Long getId();
    public  String getName();
}
