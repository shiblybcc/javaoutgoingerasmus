package com.example.outgoing.Entity;

import javax.persistence.*;
import java.util.*;

@Entity
public class Stammdaten {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
////    @JoinColumn(name = "address_id")
//    private Collection<Address> addresses = new ArrayList<Address>();

    private String firstName;
    private String lastName;
    private Integer matriculationNo;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "stammdaten" )
    private List<Address> addresses = new ArrayList<Address>();
//    private Collection<Address> addresses = new ArrayList<Address>();

//    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
//    @JoinTable(name="STAMMDATEN_LANGUAGE",
//            joinColumns={@JoinColumn(name="STAMMDATEN_ID")},
//            inverseJoinColumns={@JoinColumn(name="LANGUAGE_ID")})
//    private Set<Language> languages = new HashSet<Language>();


    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private List<Language> languages = new ArrayList<Language>();



    public List<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }


//    public Set<Language> getLanguages() {
//        return languages;
//    }
//
//    public void setLanguages(Set<Language> languages) {
//        this.languages = languages;
//    }

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
