package main.java.com.magicvet.model;

import java.util.Objects;

public class Dog extends Pet{


    private Size size;
    private String age;
    private String sex;
    private HealthState healthState;
    public Dog () { }

    public Dog(Size size) {
        this.size = size;
    }
    public Dog(Size size, String age) {
        this.size = size;
        this.age = age;
    }
    public Dog(Size size, String age, String sex, HealthState healthState) {
        setType("dog");
        this.size = size;
        this.age = age;
        this.sex = sex;
        this.setHealthState(healthState);

    }



    public void setSize(Size size) {
        this.size = size;
    }
    public Size getSize() {
        return size;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAge() {
        return age;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }
    public HealthState getHealthState() {
        return healthState;
    }

    public void setHealthState(HealthState healthState) {
        this.healthState = healthState;
    }



    public enum Size {
        XS(1),
        S(2),
        M(3),
        L(4),
        XL(5),
        XXL(6),
        UNKNOWN(0);

        private final int value;

        Size(int value){
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
    @Override
    public String toString() {
        return "Pet {" +
                "type = " + getType() +
                ", name = " + getName() +
                ", sex = " + getSex() +
                ", age = " + getAge() +
                ", size = " + getSize() +
                ", health = " + getHealthState() +
                ", ownerName = " + getOwnerName() +
                ", registrationDate = " + getFormattedRegistrationDate() +
                "}";
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dog dog)) return false;
        return Objects.equals(size, dog.size) &&
                Objects.equals(age, dog.age) &&
                Objects.equals(sex, dog.sex) &&
                getHealthState() == dog.getHealthState();

    }

    @Override
    public int hashCode() {
        return Objects.hash(size, getAge(), getSex(), getHealthState());
    }
}