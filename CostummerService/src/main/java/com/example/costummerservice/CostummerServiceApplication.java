package com.example.costummerservice;

import com.example.costummerservice.entities.Costumer;
import com.example.costummerservice.repository.CostummerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.List;

@SpringBootApplication
public class CostummerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CostummerServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(CostummerRepository costummerRepository, RepositoryRestConfiguration restConfiguration){
        return args -> {
            restConfiguration.exposeIdsFor(Costumer.class);
//            costummerRepository.saveAll(
//                    List.of(
//                            Costumer.builder().name("fatma").email("fatma@gmail.com").build(),
//                            Costumer.builder().name("lhoussaine").email("lho@gmail.com").build(),
//                            Costumer.builder().name("mohamed").email("mohamd@gmail.com").build()
//                    )
//            );
            costummerRepository.findAll().forEach(System.out::println);

        };
    }
}
