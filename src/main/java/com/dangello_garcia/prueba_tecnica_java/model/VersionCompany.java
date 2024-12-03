package com.dangello_garcia.prueba_tecnica_java.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "version_company")
public class VersionCompany {
    @Id
    private int version_company_id;

    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "id_company")
    private Company company;

    @ManyToOne
    @JoinColumn(name = "version_id", referencedColumnName = "version_id")
    private Version version;

    private String version_company_description;
}
