package com.example.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity(name = "User")
@Table(name = "user")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "phone")
    private String phone;
    
    @Column(name = "password")
    private String password;
    
    @Column(name = "full_name")
    private String fullName;
    
    @Column(name = "gender")
    private Boolean gender;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "dob")
    private Date dob;
    
    @Column(name = "status")
    private Short status;
    
    @Column(name = "created_at")
    private Date createdAt;
    
    @Column(name = "updated_at")
    private Date updatedAt;
    
    @Column(name = "user_role")
    private Short userRole;
}
