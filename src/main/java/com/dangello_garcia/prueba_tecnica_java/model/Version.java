package com.dangello_garcia.prueba_tecnica_java.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "version")
public class Version {
    @Id
    private int version_id;

    @OneToOne
    @JoinColumn(name = "app_id", referencedColumnName = "app_id")
    private Application application;

    private String version;
    private String version_description;

    @OneToMany(mappedBy = "version", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VersionCompany> versionCompanies;
}
