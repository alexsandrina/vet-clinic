package main.java.com.magicvet.model;

import java.util.Objects;

public class Cat extends Pet {

    public Cat() {}

    public Cat(String age, String sex, HealthState healthState) {
        this.setAge(age);
        this.setSex(sex);
        this.setHealthState(healthState);
    }

    @Override
    public String toString() {
        return "Cat{"
                + ", ownerName = " + getOwnerName()
                + ", type = " + getType()
                + ", sex = " + getSex()
                + ", age = " + getAge()
                + ", name = " + getName()
                + ", healthState = " + getHealthState()
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cat cat)) return false;
        return Objects.equals(getAge(), cat.getAge())
                && Objects.equals(getSex(), cat.getSex())
                && getHealthState() == cat.getHealthState();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAge(), getSex(), getHealthState());
    }
}
