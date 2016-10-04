package com.example.outgoing.Entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
//@Getter
//@Setter
public class User {

    @Id
    @Column(name = "user_id", nullable = false)
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column(nullable = true)
    private String firstName;

    @Column(nullable = true)
        private String lastName;

    @Column(nullable = true)
    private String username;

    @Column(nullable = true)
    private String password;


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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
