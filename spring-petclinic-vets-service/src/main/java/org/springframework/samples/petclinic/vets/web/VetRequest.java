package org.springframework.samples.petclinic.vets.web;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Digits;
public record VetRequest (@NotBlank String firstName,
                          @NotBlank String lastName) {

}
