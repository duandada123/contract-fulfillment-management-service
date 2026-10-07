package com.zdph.contract.fulfillment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {"com.zdph.contract.fulfillment.domain"})
@EnableJpaRepositories(basePackages = {"com.zdph.contract.fulfillment.domain"})
@SpringBootApplication
public class ContractFulfillmentServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContractFulfillmentServiceApplication.class, args);
    }

}
