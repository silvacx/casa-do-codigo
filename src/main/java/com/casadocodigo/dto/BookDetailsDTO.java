package com.casadocodigo.dto;

import com.casadocodigo.model.Book;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;

public class BookDetailsDTO {
    private DetailsAuthorDTO author;
    private String title;
    private String resume;
    private String summary;
    private BigDecimal price;
    private int numberPages;
    private String isbn;
    private String datePublish;


    @Deprecated
    public BookDetailsDTO() {
    }

    public BookDetailsDTO(Book book) {

        author = new DetailsAuthorDTO(book.getAuthor());
        title = book.getTitle();
        isbn = book.getIsbn();
        numberPages = book.getNumberPages();
        price = book.getPrice();
        resume = book.getResume();
        summary = book.getSummary();
        datePublish = book.getDatePublish().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public DetailsAuthorDTO getAuthor() {
        return author;
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

    public int getNumberPages() {
        return numberPages;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getDatePublish() {
        return datePublish;
    }
}
