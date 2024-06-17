package main.java.com.magicvet;

import main.java.com.magicvet.comparator.DogAgeComparator;
import main.java.com.magicvet.comparator.DogSexComparator;
import main.java.com.magicvet.comparator.DogSizeComparator;

import main.java.com.magicvet.model.Dog;



import java.util.Arrays;

public class Sandbox {
    public static void main(String[] args) {

        Dog[] dogs = {
                new Dog(Dog.M, "age 5", "male"),
                new Dog(Dog.S, "age 8", "female" ),
                new Dog(Dog.XS, "age 2", "female"),
                new Dog(Dog.XL, "age 1", "male"),
                new Dog(Dog.L, "age 9", "male"),
                new Dog(Dog.S, "age 3", "female"),
                new Dog(Dog.XL, "age 7", "male"),
                new Dog(Dog.XL, "age 4", "female")

        };

        Arrays.sort(dogs, new DogSizeComparator());
        System.out.println("\nSorted by size:");
                for (Dog dog : dogs) {
                 System.out.println(dog.getSize() + " - " + dog.getAge() + " - " + dog.getSex());
        }

        Arrays.sort(dogs, new DogAgeComparator());
        System.out.println("\nSorted by age:");
        for (Dog dog : dogs) {
            System.out.println(dog.getAge() + " - " + dog.getSize() + " - " + dog.getSex());

        }

            Arrays.sort(dogs, new DogSexComparator());
            System.out.println("\nSorted by sex:");
            for (Dog dog : dogs) {
                System.out.println(dog.getSex() + " - " + dog.getSize() + " - " + dog.getAge());


        }
    }
}







