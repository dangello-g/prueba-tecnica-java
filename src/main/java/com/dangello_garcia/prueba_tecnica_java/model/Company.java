package com.dangello_garcia.prueba_tecnica_java.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "company")
public class Company {
    @Id
    private int id_company;

    @Column(name = "codigo_company")
    private String codigoCompany;

    private String name_company;
    private String description_company;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VersionCompany> versionCompanies;

    public Company(int id_company, String codigo_company, String name_company, String description_company) {
        this.id_company = id_company;
        this.codigoCompany = codigo_company;
        this.name_company = name_company;
        this.description_company = description_company;
    }

    public Company() {

    }

    public void setId_company(int id_company) {
        this.id_company = id_company;
    }

    public void setCodigo_company(String codigo_company) {
        this.codigoCompany = codigo_company;
    }

    public void setName_company(String name_company) {
        this.name_company = name_company;
    }

    public void setDescription_company(String description_company) {
        this.description_company = description_company;
    }

    public int getId_company() {
        return id_company;
    }

    public String getCodigoCompany() {
        return codigoCompany;
    }

    public String getName_company() {
        return name_company;
    }

    public String getDescription_company() {
        return description_company;
    }
}
