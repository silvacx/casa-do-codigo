package com.casadocodigo.dto;

import com.casadocodigo.annotations.UniqueValue;
import com.casadocodigo.model.Category;

import javax.validation.constraints.NotBlank;

public class CategoryDTO {

    @NotBlank(message = "is required")
    @UniqueValue(domainClass = Category.class, fieldName = "name", message = "already registered")
    private String name;

    @Deprecated
    public CategoryDTO() {
    }

    public CategoryDTO(@NotBlank String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Category toModel() {
        return new Category(this.name);
    }
}
