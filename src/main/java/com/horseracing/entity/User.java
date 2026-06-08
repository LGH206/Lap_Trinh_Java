package com.horseracing.entity;

import java.time.LocalDateTime;
//abc
// Lop cha truu tuong dai dien cho tat ca nguoi dung trong he thong.
// Duoc ke thua boi cac lop nhu Jockey, Admin, va cac doi tuong nguoi dung khac.
public abstract class User {

    private int userId;
    private String username;
    private String passwordHash;
    private String email;
    private String fullName;
    private String phone;
    private String role;         // HORSE_OWNER, JOCKEY, REFEREE, SPECTATOR, ADMIN
    private String status;       // ACTIVE, INACTIVE, BANNED
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public User() {}

    public User(String username, String passwordHash, String email,
                String fullName, String phone, String role) {
        this.username = username;
        this.passwordHash = passwordHash;
        this.email = email;
        this.fullName = fullName;
        this.phone = phone;
        this.role = role;
        this.status = "ACTIVE";
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    // Getters & Setters
    public int getUserId()                      { return userId; }
    public void setUserId(int userId)           { this.userId = userId; }

    public String getUsername()                 { return username; }
    public void setUsername(String username)    { this.username = username; }

    public String getPasswordHash()             { return passwordHash; }
    public void setPasswordHash(String ph)      { this.passwordHash = ph; }

    public String getEmail()                    { return email; }
    public void setEmail(String email)          { this.email = email; }

    public String getFullName()                 { return fullName; }
    public void setFullName(String fullName)    { this.fullName = fullName; }

    public String getPhone()                    { return phone; }
    public void setPhone(String phone)          { this.phone = phone; }

    public String getRole()                     { return role; }
    public void setRole(String role)            { this.role = role; }

    public String getStatus()                   { return status; }
    public void setStatus(String status)        { this.status = status; }

    public LocalDateTime getCreatedAt()         { return createdAt; }
    public void setCreatedAt(LocalDateTime t)   { this.createdAt = t; }

    public LocalDateTime getUpdatedAt()         { return updatedAt; }
    public void setUpdatedAt(LocalDateTime t)   { this.updatedAt = t; }
}
