/*
 * Copyright 2002-2021 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.samples.petclinic.customers.web;

import io.micrometer.core.annotation.Timed;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.samples.petclinic.customers.model.Visit;
import org.springframework.samples.petclinic.customers.model.VisitRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Juergen Hoeller
 * @author Ken Krebs
 * @author Arjen Poutsma
 * @author Michael Isvy
 * @author Maciej Szarlinski
 * @author Ramazan Sakin
 */
@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/visits")
@Timed("petclinic.visit")
class VisitResource {

    private final VisitRepository visitRepository;

    @PostMapping("/visits/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Visit create(@Valid @RequestBody Visit visit) {
        return visitRepository.save(visit);
    }

    @PostMapping("/visits/update/{visitId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@Valid @RequestBody Visit visit, @PathVariable("visitId") @Min(1) int visitId) {
        visit.setId(visitId);
        visitRepository.save(visit);
    }

    @DeleteMapping("/visits/{visitId}")
    public void delete(@PathVariable("visitId") @Min(1) int visitId) {
        visitRepository.deleteById(visitId);
    }

    @GetMapping("/pets/visits/{petId}")
    public Visits readID(@PathVariable("petId") @Min(1) int petId) {
        return new Visits(visitRepository.findByPetId(petId));
    }

    @GetMapping("/visits")
    public Visits read() {
        final List<Visit> allVisits = visitRepository.findAll();
        return new Visits(allVisits);
    }

    @Value
    static class Visits {
        List<Visit> items;
    }
}
