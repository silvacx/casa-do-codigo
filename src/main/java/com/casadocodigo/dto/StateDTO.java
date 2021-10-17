package com.casadocodigo.dto;

import com.casadocodigo.annotations.ExistsValue;
import com.casadocodigo.annotations.UniqueValue;
import com.casadocodigo.model.Country;
import com.casadocodigo.model.State;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class StateDTO {

    @NotBlank
    @UniqueValue(domainClass = State.class, fieldName = "name", message = "already registered")
    private String name;

    @NotNull(message = "is required")
    @ExistsValue(domainClass = Country.class, fieldName = "id", message = "the country does not exist")
    private Long countryId;


    public StateDTO(@NotBlank String name, @NotNull(message = "is required") Long countryId) {
        this.name = name;
        this.countryId = countryId;
    }

    public State toModel(EntityManager entityManager) {
        return new State(name, entityManager.find(Country.class, countryId));
    }
}
