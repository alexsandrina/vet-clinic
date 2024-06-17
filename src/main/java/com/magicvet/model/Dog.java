package main.java.com.magicvet.model;
import java.util.Objects;

public class Dog extends Pet {

    public static final String XS = "XS";
    public static final String S = "S";
    public static final String M = "M";
    public static final String L = "L";
    public static final String XL = "XL";

    private String size;
    private String age;
    private String sex;
    public Dog () { }

    public Dog(String size) {
        this.size = size;
    }
    public Dog(String size, String age) {
        this.size = size;
        this.age = age;
    }
    public Dog(String size, String age, String sex) {
        this.size = size;
        this.age = age;
        this.sex = sex;
    }



    public void setSize(String size) {
        this.size = size;
    }
    public String getSize() {
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

    @Override
    public String toString() {
        return "Dog{"
                + ", ownerName = " + getOwnerName()
                + "size = " + size
                + ", type = " + getType()
                + ", sex = " + getSex()
                + ", age = " + getAge()
                + ", name = " + getName()
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dog dog)) return false;
         return Objects.equals(size, dog.size) &&
                Objects.equals(age, dog.age) &&
                Objects.equals(sex, dog.sex);

    }

    @Override
    public int hashCode() {
        return Objects.hashCode(size);
    }
}
