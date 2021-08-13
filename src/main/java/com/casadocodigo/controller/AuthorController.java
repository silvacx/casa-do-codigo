package com.casadocodigo.controller;

import com.casadocodigo.dto.AuthorDTO;
import com.casadocodigo.model.Author;
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
@RequestMapping(value="author")
public class AuthorController {

    @PersistenceContext
    EntityManager entityManager;

    @PostMapping
    @Transactional
    public ResponseEntity<?> newAuthor(@RequestBody @Valid AuthorDTO authorDTO) {
        Author createAuthor = authorDTO.transformAuthor();
        entityManager.persist(createAuthor);
        return ResponseEntity.status(HttpStatus.OK).body(createAuthor);
    }
}
