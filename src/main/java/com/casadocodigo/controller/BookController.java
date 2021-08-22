package com.casadocodigo.controller;

import com.casadocodigo.dto.BookDTO;
import com.casadocodigo.model.Book;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.Valid;
import java.util.List;

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

    @GetMapping
    public ResponseEntity<?> listBooks() {
        try {
            Query query = entityManager.createQuery("SELECT b FROM Book b", Book.class);
            List<Book> list = query.getResultList();
            return ResponseEntity.status(HttpStatus.OK).body(list);
        } catch (Exception err) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


}
