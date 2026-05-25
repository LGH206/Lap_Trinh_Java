package com.horseracing.entity;

public class Horse {
    private Long horseId;
    private String horseName;
    private Integer age;
    private String breed;
    private Double weight;
    private String healthStatus;

    public Horse(){}

    public Horse(Long horseId, String horseName, Integer age, String breed, Double weight, String healthStatus) {
        this.horseId = horseId;
        this.horseName = horseName;
        this.age = age;
        this.breed = breed;
        this.weight = weight;
        this.healthStatus = healthStatus;
    }

    //getter

    public Long getHorseId() {
        return horseId;
    }

    public String getHorseName() {
        return horseName;
    }

    public Integer getAge() {
        return age;
    }

    public String getBreed() {
        return breed;
    }

    public Double getWeight() {
        return weight;
    }

    public String getHealthStatus() {
        return healthStatus;
    }

    //Setter

    public void setHorseId(Long horseId) {
        this.horseId = horseId;
    }

    public void setHorseName(String horseName) {
        this.horseName = horseName;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public void setHealthStatus(String healthStatus) {
        this.healthStatus = healthStatus;
    }
}
