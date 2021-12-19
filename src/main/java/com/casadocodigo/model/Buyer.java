package com.casadocodigo.model;

import javax.persistence.*;

@Entity(name = "buyer")
public class Buyer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String cpfCnpj;
    private String address;
    private String complement;
    private String city;
    private String phone;
    private String zipCode;

    @ManyToOne
    private State state;

    @ManyToOne
    private Country country;

    @Deprecated
    public Buyer() {
    }

    public Buyer(String name, String surname, String email, String cpfCnpj,
                 String address, String complement, String city,
                 String phone, String zipCode, State state, Country country) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.cpfCnpj = cpfCnpj;
        this.address = address;
        this.complement = complement;
        this.city = city;
        this.phone = phone;
        this.zipCode = zipCode;
        this.state = state;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public String getAddress() {
        return address;
    }

    public String getComplement() {
        return complement;
    }

    public String getCity() {
        return city;
    }

    public String getPhone() {
        return phone;
    }

    public String getZipCode() {
        return zipCode;
    }

    public State getState() {
        return state;
    }

    public Country getCountry() {
        return country;
    }
}
