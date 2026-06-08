package com.horseracing.entity;

import java.time.LocalDateTime;

// Thuc the Invitation (Loi moi jockey)
// Chu Ngua gui loi moi den Jockey de dieu khien ngua cua ho trong mot tran dua cu the.
// Vong doi trang thai: PENDING -> ACCEPTED / DECLINED -> CONFIRMED (sau khi tran dua bat dau)
public class Invitation {
//ada
    private int invitationId;
    private int registrationId;     // Lien ket den don dang ky thi dau
    private int ownerId;            // Nguoi gui loi moi (Chu Ngua)
    private int jockeyId;           // Nguoi nhan loi moi (Jockey)
    private int horseId;
    private int raceId;
    private String status;          // PENDING, ACCEPTED, DECLINED, CANCELLED, CONFIRMED
    private String message;         // Thong diep cua Chu Ngua gui kem
    private String responseMessage; // Loi phan hoi tu Jockey
    private LocalDateTime sentAt;
    private LocalDateTime respondedAt;
    private LocalDateTime expiresAt; // Thoi han hieu luc cua loi moi

    public Invitation() {
        this.status = "PENDING";
        this.sentAt = LocalDateTime.now();
    }

    public Invitation(int registrationId, int ownerId, int jockeyId,
                      int horseId, int raceId, String message, LocalDateTime expiresAt) {
        this.registrationId = registrationId;
        this.ownerId   = ownerId;
        this.jockeyId  = jockeyId;
        this.horseId   = horseId;
        this.raceId    = raceId;
        this.message   = message;
        this.expiresAt = expiresAt;
        this.status    = "PENDING";
        this.sentAt    = LocalDateTime.now();
    }

    // Getters & Setters
    public int getInvitationId()                { return invitationId; }
    public void setInvitationId(int id)         { this.invitationId = id; }

    public int getRegistrationId()              { return registrationId; }
    public void setRegistrationId(int id)       { this.registrationId = id; }

    public int getOwnerId()                     { return ownerId; }
    public void setOwnerId(int ownerId)         { this.ownerId = ownerId; }

    public int getJockeyId()                    { return jockeyId; }
    public void setJockeyId(int jockeyId)       { this.jockeyId = jockeyId; }

    public int getHorseId()                     { return horseId; }
    public void setHorseId(int horseId)         { this.horseId = horseId; }

    public int getRaceId()                      { return raceId; }
    public void setRaceId(int raceId)           { this.raceId = raceId; }

    public String getStatus()                   { return status; }
    public void setStatus(String status)        { this.status = status; }

    public String getMessage()                  { return message; }
    public void setMessage(String message)      { this.message = message; }

    public String getResponseMessage()          { return responseMessage; }
    public void setResponseMessage(String msg)  { this.responseMessage = msg; }

    public LocalDateTime getSentAt()            { return sentAt; }
    public void setSentAt(LocalDateTime t)      { this.sentAt = t; }

    public LocalDateTime getRespondedAt()       { return respondedAt; }
    public void setRespondedAt(LocalDateTime t) { this.respondedAt = t; }

    public LocalDateTime getExpiresAt()         { return expiresAt; }
    public void setExpiresAt(LocalDateTime t)   { this.expiresAt = t; }

    // Tra ve true neu thoi han cua loi moi da qua thoi gian hien tai
    public boolean isExpired() {
        return expiresAt != null && LocalDateTime.now().isAfter(expiresAt);
    }
}
