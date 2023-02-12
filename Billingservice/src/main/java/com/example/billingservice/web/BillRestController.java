package com.example.billingservice.web;

import com.example.billingservice.entities.Bill;
import com.example.billingservice.repository.Billrepository;
import com.example.billingservice.repository.ProductitemRepository;
import com.example.billingservice.service.CustomerRestClient;
import com.example.billingservice.service.ProductRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillRestController {
    @Autowired
    private Billrepository billrepository;
    @Autowired
    private ProductitemRepository productitemRepository;
    @Autowired
    private CustomerRestClient customerRestClient;
    @Autowired
    private ProductRestClient productRestClient;


    @GetMapping("/fullBill/{id}")
    public Bill bill(@PathVariable Long id)
    {
        Bill bill=billrepository.findById(id).get();
        bill.setCostumer(customerRestClient.findCustomerByid(bill.getCustomerid()));
        bill.getProductsitems().forEach(pi->{
            pi.setProduct(productRestClient.findProducyByid(pi.getProductId()));
        });
        return bill;

    }
}
