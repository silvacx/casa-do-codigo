package com.casadocodigo.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Entity(name = "books")
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank private String title;

  @Size(max = 500)
  private String resume;

  private String summary;

  @NotNull
  @Min(20)
  private BigDecimal price;

  @Min(100)
  private Integer numberPages;

  @NotBlank private String isbn;

  private LocalDate datePublish;

  @ManyToOne private Category category;

  @ManyToOne private Author author;

  @Deprecated
  public Book() {}

  public Book(@NotBlank String title,
              @NotBlank @Size(max = 500) String resume,
              String summary,
              @Min(20) BigDecimal price,
              @NotBlank @Min(100) Integer numberPages,
              @NotBlank String isbn,
              LocalDate datePublish,
              Category category,
              Author author) {
    this.title = title;
    this.resume = resume;
    this.summary = summary;
    this.price = price;
    this.numberPages = numberPages;
    this.isbn = isbn;
    this.datePublish = datePublish;
    this.category = category;
    this.author = author;
  }

  public Long getId() {
    return id;
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

  public Category getCategory() {
        return category;
    }

  public Author getAuthor() {
        return author;
    }
}
