package com.example.outgoing.Entity;

import javax.persistence.*;
import java.util.*;

@Entity
public class Stammdaten {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String firstName;
    private String lastName;
    private Integer matriculationNo;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "stammdaten" )
    private List<Address> addresses = new ArrayList<Address>();

    @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER, mappedBy = "stammdaten" )
    private List<LanguageSkill> languageSkills = new ArrayList<LanguageSkill>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "stammdaten" )
    private List<StammdatenFile> stammdatenFiles = new ArrayList<StammdatenFile>();

    //getters setters

    public List<StammdatenFile> getStammdatenFiles() {
        return stammdatenFiles;
    }

    public void setStammdatenFiles(List<StammdatenFile> stammdatenFiles) {
        this.stammdatenFiles = stammdatenFiles;
    }

    public List<LanguageSkill> getLanguageSkills() {
        return languageSkills;
    }

    public void setLanguageSkills(List<LanguageSkill> languageSkills) {
        this.languageSkills = languageSkills;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getMatriculationNo() {
        return matriculationNo;
    }

    public void setMatriculationNo(Integer matriculationNo) {
        this.matriculationNo = matriculationNo;
    }
}
