package org.springframework.samples.petclinic.pets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author zhaoyiming
 */
@EnableDiscoveryClient
@SpringBootApplication
public class PetsServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(PetsServiceApplication.class, args);
    }
}
