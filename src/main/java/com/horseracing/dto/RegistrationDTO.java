package com.horseracing.dto;

import java.time.LocalDateTime;

public class RegistrationDTO {

    private int registrationId;
    private int raceId;
    private String raceName;
    private int horseId;
    private String horseName;
    private int ownerId;
    private String ownerName;
    private int jockeyId;
    private String jockeyName;
    private String status;
    private String notes;
    private LocalDateTime registeredAt;
    private LocalDateTime updatedAt;

    public RegistrationDTO() {}

    // Getters & Setters
    public int getRegistrationId(){
        return registrationId;
    }
    public void setRegistrationId(int id){
        this.registrationId = id;
    }

    public int getRaceId(){
        return raceId;
    }
    public void setRaceId(int raceId){
        this.raceId = raceId;
    }

    public String getRaceName(){
        return raceName;
    }
    public void setRaceName(String raceName){
        this.raceName = raceName;
    }

    public int getHorseId(){
        return horseId;
    }
    public void setHorseId(int horseId){
        this.horseId = horseId;
    }

    public String getHorseName(){
        return horseName;
    }
    public void setHorseName(String horseName){
        this.horseName = horseName;
    }

    public int getOwnerId(){
        return ownerId;
    }
    public void setOwnerId(int ownerId){
        this.ownerId = ownerId;
    }

    public String getOwnerName(){
        return ownerName;
    }
    public void setOwnerName(String ownerName){
        this.ownerName = ownerName;
    }

    public int getJockeyId(){
        return jockeyId;
    }
    public void setJockeyId(int jockeyId){
        this.jockeyId = jockeyId;
    }

    public String getJockeyName(){
        return jockeyName;
    }
    public void setJockeyName(String jockeyName){
        this.jockeyName = jockeyName;
    }

    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status = status;
    }

    public String getNotes(){
        return notes;
    }
    public void setNotes(String notes){
        this.notes = notes;
    }

    public LocalDateTime getRegisteredAt(){
        return registeredAt;
    }
    public void setRegisteredAt(LocalDateTime t){
        this.registeredAt = t;
    }

    public LocalDateTime getUpdatedAt(){
        return updatedAt;
    }
    public void setUpdatedAt(LocalDateTime t){
        this.updatedAt = t;
    }
}
