package com.casadocodigo.dto;

import com.casadocodigo.annotations.UniqueValue;
import com.casadocodigo.model.Author;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AuthorDTO {

    @NotBlank(message = "is required")
    private String name;

    @Email(message = "Invalid email address")
    @NotBlank(message = "is required")
    @UniqueValue(domainClass = Author.class, fieldName = "email", message = "already registered")
    private String email;

    @NotBlank(message = "is required")
    @Size(max = 400, message = "400 characters")
    private String description;


    @Deprecated
    public AuthorDTO() {
    }

    public AuthorDTO(@NotBlank String name, @Email @NotBlank String email, @NotBlank @Size(max = 400) String description) {
        this.name = name;
        this.email = email;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDescription() {
        return description;
    }

    public Author transformAuthor(){
        return new Author(this.name, this.email, this.description);
    }
}
