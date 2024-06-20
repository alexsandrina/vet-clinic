package main.java.com.magicvet.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public abstract class Pet {
    static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("HH:mm dd/MM/yyyy");
    private String type;
    private String sex;
    private String age;
    private String name;
    private String ownerName;
    private HealthState healthState;
    private final LocalDateTime registrationDate = LocalDateTime.now();
    public enum HealthState {
        EXCELLENT,
        GOOD,
        FAIR,
        POOR
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getOwnerName() {
        return ownerName;
    }
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
    public HealthState getHealthState() {
        return healthState;
    }
    public void setHealthState(HealthState healthState) {
        this.healthState = healthState;
    }
    public String getFormattedRegistrationDate() {
        return registrationDate.format(FORMATTER);
    }
        @Override
    public String toString() {
        return "Pet{"
                + "type = " + type
                + ", sex = " + sex
                + ", age = " + age
                + ", name = " + name
                + ", healthState = " + healthState
                + ", ownerName = " + ownerName
                + ", registrationDate = " + getFormattedRegistrationDate() //registrationDate.format(FORMATTER)
                + '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pet pet)) return false;
        return Objects.equals(type, pet.type)
                && Objects.equals(sex, pet.sex)
                && Objects.equals(age, pet.age)
                && Objects.equals(name, pet.name)
                && Objects.equals(ownerName, pet.ownerName)
                && healthState == pet.healthState
                && registrationDate.equals(pet.registrationDate);
    }
    @Override
    public int hashCode() {
        return Objects.hash(type, sex, age, name, ownerName, healthState, registrationDate);
    }
}