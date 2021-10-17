package com.casadocodigo.controller;

import com.casadocodigo.dto.CategoryDTO;
import com.casadocodigo.model.Category;
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
@RequestMapping(value = "category")
public class CategoryController {

    @PersistenceContext
    EntityManager entityManager;

    @PostMapping
    @Transactional
    public ResponseEntity<?> newCategory(@RequestBody @Valid CategoryDTO categoryDTO) {
        Category createCategory = categoryDTO.toModel();
        entityManager.persist(createCategory);
        return ResponseEntity.status(HttpStatus.OK).body(createCategory);
    }
}
