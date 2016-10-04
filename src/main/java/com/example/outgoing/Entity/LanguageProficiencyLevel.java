package com.example.outgoing.Entity;

import javax.persistence.*;

@Entity
public class LanguageProficiencyLevel {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

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
