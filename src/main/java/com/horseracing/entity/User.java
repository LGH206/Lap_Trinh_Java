package com.horseracing.entity;
import com.horseracing.interfaces.IUserAuthentication;

import java.util.Date;

public abstract class User implements IUserAuthentication {
    protected Long id;
    protected String fullName;
    protected String email;
    protected String password;
    protected Date createdDate;

    public User() {
    }

    public User(Long id, String fullName, String email, String password, Date createdDate) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.createdDate = createdDate;
    }

    //Getter
    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    //Setter

    public void setId(Long id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
