package com.casadocodigo.controller;

import com.casadocodigo.dto.BookDTO;
import com.casadocodigo.model.Book;
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
@RequestMapping(value = "book")
public class BookController {

    @PersistenceContext
    EntityManager entityManager;

    @PostMapping
    @Transactional
    public ResponseEntity<?> newBook(@RequestBody @Valid BookDTO bookDTO) {
        Book createBook = bookDTO.toModel(entityManager);
        entityManager.persist(createBook);
        return ResponseEntity.status(HttpStatus.OK).body(createBook);
    }
}
