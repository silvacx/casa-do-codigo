package com.casadocodigo.controller;

import com.casadocodigo.dto.CountryDTO;
import com.casadocodigo.model.Country;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "country")
public class CountryController {

    @PersistenceContext
    EntityManager entityManager;

    @PostMapping
    @Transactional
    public ResponseEntity<?> createCountry(@RequestBody @Valid CountryDTO countryDTO) {
        Country newCountry = countryDTO.toModel();
        entityManager.persist(newCountry);
        return ResponseEntity.status(HttpStatus.OK).body(newCountry);
    }
}
