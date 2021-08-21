package com.casadocodigo.dto;

import com.casadocodigo.annotations.ExistsValue;
import com.casadocodigo.annotations.UniqueValue;
import com.casadocodigo.model.Author;
import com.casadocodigo.model.Book;
import com.casadocodigo.model.Category;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;

import javax.persistence.EntityManager;
import javax.servlet.annotation.MultipartConfig;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class BookDTO {

    @NotBlank(message = "is required")
    @UniqueValue(domainClass = Book.class, fieldName = "title", message = "already registered")
    private String title;

    @NotBlank(message = "is required")
    @Size(max = 500)
    private String resume;

    private String summary;

    @NotNull
    @Min(20)
    private BigDecimal price;

    @NotNull
    @Min(100)
    private Integer numberPages;

    @NotBlank(message = "is required")
    @UniqueValue(domainClass = Book.class, fieldName = "isbn", message = "already registered")
    private String isbn;

    @Future
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate datePublish;

    @NotNull
    @ExistsValue(domainClass = Category.class, fieldName = "id", message = "the category does not exist")
    private Long categoryId;

    @NotNull
    @ExistsValue(domainClass = Author.class, fieldName = "id", message = "the author does not exist")
    private Long authorId;

    @Deprecated
    public BookDTO() {
    }

    public BookDTO(@NotBlank(message = "is required") String title,
                   @NotBlank(message = "is required") @Size(max = 500) String resume,
                   String summary,
                   @Min(20) BigDecimal price,
                   @Min(100) Integer numberPages,
                   @NotBlank(message = "is required") String isbn,
                   @Future LocalDate datePublish,
                   Long categoryId,
                   Long authorId) {
        this.title = title;
        this.resume = resume;
        this.summary = summary;
        this.price = price;
        this.numberPages = numberPages;
        this.isbn = isbn;
        this.datePublish = datePublish;
        this.categoryId = categoryId;
        this.authorId = authorId;
    }

    public String getTitle() {
        return title;
    }

    public String getResume() {
        return resume;
    }

    public String getSummary() {
        return summary;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Integer getNumberPages() {
        return numberPages;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getDatePublish() {
        return datePublish;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public Book toModel(EntityManager entityManager){
        Author author = entityManager.find(Author.class, this.authorId);
        Category category = entityManager.find(Category.class, this.categoryId);

        return new Book(this.title, this.resume, this.summary, this.price,
                this.numberPages, this.isbn, this.datePublish, category, author);
    }
}
