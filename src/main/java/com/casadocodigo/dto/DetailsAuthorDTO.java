package com.casadocodigo.dto;

import com.casadocodigo.model.Author;

public class DetailsAuthorDTO {

    private String name;
    private String description;

    public DetailsAuthorDTO (Author author) {
        name = author.getName();
        description = author.getDescription();
    }


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
