package com.example.davideshop.model;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // lets class know its a java class
@Table(name = "users") // finds users in database
public class userEntity {
    @Id // lets class know that id is an ID
    @GeneratedValue(strategy = GenerationType.IDENTITY) // updates ID value. the database generates the value
                                                        // automatically.
    private Long id;

    @Column(nullable = false, unique = true, length = 255)
    private String email;

    @Column(name = "password", nullable = false, length = 255)
    private String password; // hashed
    @Column(name = "full_name", length = 255)
    private String fullName;

    @Column(length = 50, nullable = false)
    private String role = "Customer";

    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt = Instant.now();

    @Column(name = "address", length = 255)
    private String address;
    @Column(name = "zipcode", length = 255)
    private String zipcode;
    @Column(name = "country", length = 255)
    private String country;
    @Column(name = "city", length = 255)
    private String city;

    // === getters & setters ===
    public Long getId() {
        return id;
    }

    // no setter for id; DB sets it
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String passwordHash) {
        this.password = passwordHash;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public String getAddress() {
    return address;
}

public void setAddress(String address) {
    this.address = address;
}

public String getZipcode() {
    return zipcode;
}

public void setZipcode(String zipcode) {
    this.zipcode = zipcode;
}

public String getCountry() {
    return country;
}

public void setCountry(String country) {
    this.country = country;
}

public String getCity() {
    return city;
}

public void setCity(String city) {
    this.city = city;
}
}
