package com.horseracing.dto;

/**
 * DTO returned when listing jockeys – used in views and JSON responses.
 */
public class JockeyDTO {

    private int jockeyId;
    private int userId;
    private String fullName;
    private String licenseNumber;
    private String nationality;
    private double weight;
    private int experienceYears;
    private int totalRaces;
    private int totalWins;
    private double winRate;
    private String jockeyStatus;
    private String profileImageUrl;
    private String email;
    private String phone;
//
    public JockeyDTO() {}

    // Getters & Setters
    public int getJockeyId(){
        return jockeyId;
    }
    public void setJockeyId(int jockeyId){
        this.jockeyId = jockeyId;
    }

    public int getUserId(){
        return userId;
    }
    public void setUserId(int userId){
        this.userId = userId;
    }

    public String getFullName(){
        return fullName;
    }
    public void setFullName(String fullName){
        this.fullName = fullName;
    }

    public String getLicenseNumber(){ return licenseNumber; }
    public void setLicenseNumber(String ln){
        this.licenseNumber = ln;
    }
    public String getNationality(){
        return nationality;
    }
    public void setNationality(String nationality){
        this.nationality = nationality;
    }

    public double getWeight(){
        return weight;
    }
    public void setWeight(double weight){
        this.weight = weight;
    }

    public int getExperienceYears(){
        return experienceYears;
    }
    public void setExperienceYears(int y){
        this.experienceYears = y;
    }

    public int getTotalRaces(){
        return totalRaces;
    }
    public void setTotalRaces(int totalRaces){
        this.totalRaces = totalRaces;
    }

    public int getTotalWins(){
        return totalWins;
    }
    public void setTotalWins(int totalWins){
        this.totalWins = totalWins;
    }

    public double getWinRate(){
        return winRate;
    }
    public void setWinRate(double winRate){
        this.winRate = winRate;
    }

    public String getJockeyStatus(){
        return jockeyStatus;
    }
    public void setJockeyStatus(String s){
        this.jockeyStatus = s;
    }

    public String getProfileImageUrl(){
        return profileImageUrl;
    }
    public void setProfileImageUrl(String url){
        this.profileImageUrl = url;
    }

    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }

    public String getPhone(){
        return phone;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }
}
