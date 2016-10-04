package com.example.outgoing.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Language {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String name;

//    @ManyToMany(mappedBy="meetings")
//    private Set<Employee> employees = new HashSet<Employee>();

    @ManyToMany(mappedBy = "languages")
    private List<Stammdaten> stammdatens = new ArrayList<Stammdaten>();

    public List<Stammdaten> getStammdatens() {
        return stammdatens;
    }

    public void setStammdatens(List<Stammdaten> stammdatens) {
        this.stammdatens = stammdatens;
    }

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
