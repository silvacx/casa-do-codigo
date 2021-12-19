package com.casadocodigo.controller;

import com.casadocodigo.dto.BuyerDTO;
import com.casadocodigo.model.Buyer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "buyer")
public class BuyerController {

    @PersistenceContext
    EntityManager entityManager;

    @PostMapping
    @Transactional
    public ResponseEntity<?> createBuyer(@RequestBody @Valid BuyerDTO buyerDTO) {
        Buyer newBuyer = buyerDTO.toModel(entityManager);
        entityManager.persist(newBuyer);
        return ResponseEntity.status(HttpStatus.OK).body(newBuyer);
    }
}
