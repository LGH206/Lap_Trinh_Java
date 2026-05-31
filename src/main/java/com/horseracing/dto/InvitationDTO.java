package com.horseracing.dto;
import java.time.LocalDateTime;
public class InvitationDTO {
    private int invitationId;
    private int registrationId;
    private int ownerId;
    private String ownerName;
    private int jockeyId;
    private String jockeyName;
    private int horseId;
    private String horseName;
    private int raceId;
    private String raceName;
    private String raceDate;
    private String status;
    private String message;
    private String responseMessage;
    private LocalDateTime sentAt;
    private LocalDateTime respondedAt;
    private LocalDateTime expiresAt;

    public InvitationDTO() {}

    // Getters & Setters
    public int getInvitationId(){
        return invitationId;
    }
    public void setInvitationId(int id){
        this.invitationId = id;
    }

    public int getRegistrationId(){
        return registrationId;
    }
    public void setRegistrationId(int id){
        this.registrationId = id;
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
    public void setJockeyName(String n){
        this.jockeyName = n;
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

    public String getRaceDate(){
        return raceDate;
    }
    public void setRaceDate(String raceDate){
        this.raceDate = raceDate;
    }

    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status = status;
    }

    public String getMessage(){
        return message;
    }
    public void setMessage(String message){
        this.message = message;
    }

    public String getResponseMessage(){
        return responseMessage;
    }
    public void setResponseMessage(String msg){
        this.responseMessage = msg;
    }

    public LocalDateTime getSentAt(){
        return sentAt;
    }
    public void setSentAt(LocalDateTime t){
        this.sentAt = t;
    }

    public LocalDateTime getRespondedAt(){
        return respondedAt;
    }
    public void setRespondedAt(LocalDateTime t){
        this.respondedAt = t;
    }

    public LocalDateTime getExpiresAt(){
        return expiresAt;
    }
    public void setExpiresAt(LocalDateTime t){
        this.expiresAt = t;
    }
}
