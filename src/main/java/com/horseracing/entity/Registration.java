package com.horseracing.entity;

import java.time.LocalDateTime;

// Thuc the Registration (Dang ky thi dau)
// Dai dien cho viec Chu Ngua thuc hien dang ky ngua tham gia vao mot tran dua.
// Vong doi trang thai: PENDING -> APPROVED / REJECTED -> CONFIRMED / WITHDRAWN
public class Registration {
//ada
    private int registrationId;
    private int raceId;
    private int horseId;
    private int ownerId;
    private int jockeyId;           // Jockey duoc phan cong (co the null cho den khi duoc xac nhan)
    private String status;          // PENDING, APPROVED, REJECTED, CONFIRMED, WITHDRAWN
    private String notes;
    private LocalDateTime registeredAt;
    private LocalDateTime updatedAt;

    public Registration() {
        this.status = "PENDING";
        this.registeredAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public Registration(int raceId, int horseId, int ownerId) {
        this.raceId = raceId;
        this.horseId = horseId;
        this.ownerId = ownerId;
        this.status = "PENDING";
        this.registeredAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    // Getters & Setters
    public int getRegistrationId()              { return registrationId; }
    public void setRegistrationId(int id)       { this.registrationId = id; }

    public int getRaceId()                      { return raceId; }
    public void setRaceId(int raceId)           { this.raceId = raceId; }

    public int getHorseId()                     { return horseId; }
    public void setHorseId(int horseId)         { this.horseId = horseId; }

    public int getOwnerId()                     { return ownerId; }
    public void setOwnerId(int ownerId)         { this.ownerId = ownerId; }

    public int getJockeyId()                    { return jockeyId; }
    public void setJockeyId(int jockeyId)       { this.jockeyId = jockeyId; }

    public String getStatus()                   { return status; }
    public void setStatus(String status)        { this.status = status; }

    public String getNotes()                    { return notes; }
    public void setNotes(String notes)          { this.notes = notes; }

    public LocalDateTime getRegisteredAt()      { return registeredAt; }
    public void setRegisteredAt(LocalDateTime t){ this.registeredAt = t; }

    public LocalDateTime getUpdatedAt()         { return updatedAt; }
    public void setUpdatedAt(LocalDateTime t)   { this.updatedAt = t; }
}
