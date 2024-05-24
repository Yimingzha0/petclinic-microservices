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

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.samples.petclinic.customers.model.Vet;
import org.springframework.samples.petclinic.customers.model.VetRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Juergen Hoeller
 * @author Mark Fisher
 * @author Ken Krebs
 * @author Arjen Poutsma
 * @author Maciej Szarlinski
 */
@RequestMapping("/vets")
@RestController
@RequiredArgsConstructor
class VetResource {

    private final VetRepository vetRepository;

    @GetMapping
    @Cacheable("vets")
    public List<Vet> showResourcesVetList() {
        return vetRepository.findAll();
    }

    @DeleteMapping("/delete/{vetsId}")
    public void deleteVet(@PathVariable("vetsId") int id) {
        vetRepository.deleteById(id);
    }

    @GetMapping("/vets/{vetsId}")
    public Vet showVet(@PathVariable("vetsId") int id) throws Exception {
        return vetRepository.findById(id).orElseThrow(() -> new Exception("Vet " + id + " not found"));
    }

    @PostMapping("/Add")
    @ResponseStatus(HttpStatus.CREATED)
    public Vet addVet(@RequestBody VetRequest vetRequest) {
        Vet vet = new Vet();
        vet.setFirstName(vetRequest.firstName());
        vet.setLastName(vetRequest.lastName());
        return vetRepository.save(vet);
    }

    @PostMapping("/Update/{vetsId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateVet(@RequestBody VetRequest vetRequest, @PathVariable("vetsId") int id) {
        Vet vet = vetRepository.findById(id).orElseThrow(() -> new RuntimeException("Vet " + id + " not found"));
        vet.setFirstName(vetRequest.firstName());
        vet.setLastName(vetRequest.lastName());
        vetRepository.save(vet);
    }


}
