package com.dangello_garcia.prueba_tecnica_java.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "application")
public class Application {
    @Id
    private int app_id;

    @OneToOne(mappedBy = "application")
    private Version version;

    private String app_code;
    private String app_name;
    private String app_description;
}
