package com.nexalyze.nexalyze.organization.model;
import jakarta.persistence.*;

import static com.nexalyze.nexalyze.configuration.constans.DbConstants.*;

@Entity
@Table(name = TABLE_ORGANIZATION)
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = TABLE_ORGANIZATION_COLUMN_NAME)
    private String name;
    @Column(name = TABLE_ORGANIZATION_COLUMN_LICENCE)
    private Integer licence;


    public Organization(String name, Integer licence) {
        this.name = name;
        this.licence = licence;
    }

    public Organization() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLicence() {
        return licence;
    }

    public void setLicence(Integer licence) {
        this.licence = licence;
    }

    public Long getId() {
        return id;
    }
}
