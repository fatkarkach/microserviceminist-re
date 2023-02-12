package com.example.billingservice;

import com.example.billingservice.entities.Bill;
import com.example.billingservice.entities.Productsitem;
import com.example.billingservice.model.Customer;
import com.example.billingservice.model.Product;
import com.example.billingservice.repository.Billrepository;
import com.example.billingservice.repository.ProductitemRepository;
import com.example.billingservice.service.CustomerRestClient;
import com.example.billingservice.service.ProductRestClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class BillingserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingserviceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(Billrepository billrepository, ProductitemRepository productitemRepository,
                            CustomerRestClient customerRestClient, ProductRestClient productRestClient){
        return args -> {
            Collection<Product> products=productRestClient.allProducts().getContent();
            Long customerId=1L;
            Customer customer=customerRestClient.findCustomerByid(customerId);
            if(customer==null) throw new RuntimeException("Customer not found");
            Bill bill=new Bill();
            bill.setBilledate(new Date());
            bill.setCustomerid(customerId);
            Bill savedBill = billrepository.save(bill);
            products.forEach(product -> {
                Productsitem productItem=new Productsitem();
                productItem.setBill(savedBill);
                productItem.setProductId(product.getId());
                productItem.setQuantity(1+new Random().nextInt(10));
                productItem.setPrice(product.getPrice());
                productItem.setDiscount(Math.random());
                productitemRepository.save(productItem);
            });

        };
    }

}
