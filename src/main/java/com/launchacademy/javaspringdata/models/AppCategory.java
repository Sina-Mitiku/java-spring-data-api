package com.launchacademy.javaspringdata.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "categories")
public class AppCategory {
    @Id
    @SequenceGenerator(name="categories_generator",
        sequenceName="categories_id_seq", allocationSize = 1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE,
        generator="categories_generator")
    @Column(name="id", nullable=false, unique=true)
    private Integer id;

    @NotBlank
    @Column(name="name", nullable=false, unique = true)
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
