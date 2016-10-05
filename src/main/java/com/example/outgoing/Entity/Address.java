package com.example.outgoing.Entity;

import javax.persistence.*;

@Entity
public class Address {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String street;
    private Integer houseNumber;
    private Integer plz;
    private String place;
    private String addressType;  //home and semester address

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "stammdaten_id")
    private Stammdaten stammdaten;

    //getters setters
    public Stammdaten getStammdaten() {
        return stammdaten;
    }

    public void setStammdaten(Stammdaten stammdaten) {
        this.stammdaten = stammdaten;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(Integer houseNumber) {
        this.houseNumber = houseNumber;
    }

    public Integer getPlz() {
        return plz;
    }

    public void setPlz(Integer plz) {
        this.plz = plz;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }
}
