package main.java.com.magicvet.model;

import java.util.Objects;

public class Dog extends Pet {

    private String size;

    public void setSize(String size) {
        this.size = size;
    }
    public String getSize() {
        return size;
    }
    @Override
    public String toString() {
        return "Dog{"
                + "size = " + size
                //+ " type = " + getType() + '\''
                + ", sex = " + getSex()
                + ", age = " + getAge()
                + ", name = " + getName()
                + ", ownerName = " + getOwnerName()
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dog dog)) return false;
        return Objects.equals(size, dog.size);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(size);
    }
}
