package org.springframework.samples.petclinic.customers.web;

import jakarta.validation.constraints.NotBlank;

public record VetRequest (@NotBlank String firstName,
                          @NotBlank String lastName) {

}
