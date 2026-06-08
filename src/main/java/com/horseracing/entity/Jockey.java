package com.horseracing.entity;

import java.time.LocalDate;

    import org.springframework.format.annotation.DateTimeFormat;
//ad
// Thuc the Jockey (Nai ngua) - ke thua tu lop User.
// Luu tru thong tin lien quan den giay phep, quoc tich, can nang va cac chi so thi dau.
public class Jockey extends User {

    private int jockeyId;
    private String licenseNumber;
    private String nationality;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;
    private double weight;          // kg - quan trong de xet dieu kien thi dau
    private int experienceYears;
    private int totalRaces;
    private int totalWins;
    private String profileImageUrl;
    private String jockeyStatus;    // AVAILABLE, BUSY, SUSPENDED

    public Jockey() {
        super();
        setRole("JOCKEY");
        this.jockeyStatus = "AVAILABLE";
        this.totalRaces = 0;
        this.totalWins  = 0;
    }

    public Jockey(String username, String passwordHash, String email,
                  String fullName, String phone,
                  String licenseNumber, String nationality,
                  LocalDate dateOfBirth, double weight, int experienceYears) {
        super(username, passwordHash, email, fullName, phone, "JOCKEY");
        this.licenseNumber   = licenseNumber;
        this.nationality     = nationality;
        this.dateOfBirth     = dateOfBirth;
        this.weight          = weight;
        this.experienceYears = experienceYears;
        this.jockeyStatus    = "AVAILABLE";
        this.totalRaces      = 0;
        this.totalWins       = 0;
    }

    // Getters & Setters
    public int getJockeyId()                        { return jockeyId; }
    public void setJockeyId(int jockeyId)           { this.jockeyId = jockeyId; }

    public String getLicenseNumber()                { return licenseNumber; }
    public void setLicenseNumber(String ln)         { this.licenseNumber = ln; }

    public String getNationality()                  { return nationality; }
    public void setNationality(String nationality)  { this.nationality = nationality; }

    public LocalDate getDateOfBirth()               { return dateOfBirth; }
    public void setDateOfBirth(LocalDate dob)       { this.dateOfBirth = dob; }

    public double getWeight()                       { return weight; }
    public void setWeight(double weight)            { this.weight = weight; }

    public int getExperienceYears()                 { return experienceYears; }
    public void setExperienceYears(int y)           { this.experienceYears = y; }

    public int getTotalRaces()                      { return totalRaces; }
    public void setTotalRaces(int totalRaces)       { this.totalRaces = totalRaces; }

    public int getTotalWins()                       { return totalWins; }
    public void setTotalWins(int totalWins)         { this.totalWins = totalWins; }

    public String getProfileImageUrl()              { return profileImageUrl; }
    public void setProfileImageUrl(String url)      { this.profileImageUrl = url; }

    public String getJockeyStatus()                 { return jockeyStatus; }
    public void setJockeyStatus(String s)           { this.jockeyStatus = s; }

    // Tinh ti le thang cuoc theo ty le phan tram
    public double getWinRate() {
        if (totalRaces == 0) return 0.0;
        return (double) totalWins / totalRaces * 100;
    }
}
