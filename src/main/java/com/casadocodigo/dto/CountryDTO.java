package com.casadocodigo.dto;

import com.casadocodigo.annotations.UniqueValue;
import com.casadocodigo.model.Country;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;

public class CountryDTO {

    @NotBlank(message = "is required")
    @UniqueValue(domainClass = Country.class, fieldName = "name", message = "already registered")
    private String name;

    @Deprecated
    public CountryDTO() {
    }

    public CountryDTO(@NotBlank(message = "is required") String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Country toModel() {
        return new Country(this.name);
    }
}
