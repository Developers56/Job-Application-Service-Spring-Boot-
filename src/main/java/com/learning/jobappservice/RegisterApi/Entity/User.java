package com.learning.jobappservice.RegisterApi.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "register")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true)
    private String email;

    @Column(nullable = false, unique = true, length = 12)
    private String mobile;

    @Column(nullable = false, unique = true, length = 13)
    private String cnic;

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getMobile() { return mobile; }
    public void setMobile(String mobile) { this.mobile = mobile; }

    public String getCnic() { return cnic; }
    public void setCnic(String cnic) { this.cnic = cnic; }

}
