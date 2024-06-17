package main.java.com.magicvet;


import main.java.com.magicvet.model.Cat;
import main.java.com.magicvet.model.Dog;
import main.java.com.magicvet.model.Pet;


import java.util.Arrays;
import java.util.Comparator;

public class Sandbox {
    public static void main(String[] args) {

        Dog[] dogs = {

                new Dog(Dog.Size.M, "5", "male", Pet.HealthState.GOOD),
                new Dog(Dog.Size.S, "8", "female", Pet.HealthState.FAIR),
                new Dog(Dog.Size.XS, "2", "female", Pet.HealthState.EXCELLENT),
                new Dog(Dog.Size.XL, "1", "male", Pet.HealthState.POOR),
                new Dog(Dog.Size.L, "9", "male", Pet.HealthState.GOOD),
                new Dog(Dog.Size.S, "3", "female", Pet.HealthState.FAIR),
                new Dog(Dog.Size.XL, "7", "male", Pet.HealthState.POOR),
                new Dog(Dog.Size.XL, "4", "female", Pet.HealthState.GOOD),
                new Dog(Dog.Size.XXL, "4", "female", Pet.HealthState.EXCELLENT)
        };

        Cat[] cats = {
                new Cat("5", "male", Pet.HealthState.GOOD),
                new Cat("8", "female", Pet.HealthState.FAIR),
                new Cat("2", "female", Pet.HealthState.EXCELLENT),
                new Cat("1", "male", Pet.HealthState.POOR),
                new Cat("9", "male", Pet.HealthState.GOOD),
                new Cat("3", "female", Pet.HealthState.FAIR),
                new Cat("7", "male", Pet.HealthState.POOR),
                new Cat("4", "female", Pet.HealthState.GOOD),
                new Cat("4", "female", Pet.HealthState.EXCELLENT)
        };

        Pet[] pets = new Pet[dogs.length + cats.length];
        System.arraycopy(dogs, 0, pets, 0, dogs.length);
        System.arraycopy(cats, 0, pets, dogs.length, cats.length);

        Arrays.sort(dogs, Comparator.comparingInt(dog -> dog.getSize().getValue()));
        System.out.println("Sorted by size (dogs only):");
        for (Dog dog : dogs) {
            System.out.println(dog.getSize() + " - dog - age " + dog.getAge() + " - " + dog.getSex() + " - " + dog.getHealthState());
        }


        Arrays.sort(pets, Comparator.comparingInt(pet -> Integer.parseInt(pet.getAge())));
        System.out.println("\nSorted by age (dogs and cats):");
        for (Pet pet : pets) {
            System.out.println("age " + pet.getAge() + " - " + (pet instanceof Dog ? "dog - " + ((Dog) pet).getSize() : "cat") + " - " + pet.getSex() + " - " + pet.getHealthState());
        }


        Arrays.sort(pets, Comparator.comparing(Pet::getSex));
        System.out.println("\nSorted by sex (dogs and cats):");
        for (Pet pet : pets) {
            System.out.println(pet.getSex() + " - " + (pet instanceof Dog ? "dog - " + ((Dog) pet).getSize() : "cat") + " - age " + pet.getAge() + " - " + pet.getHealthState());
        }


        Arrays.sort(pets, Comparator.comparing(Pet::getHealthState));
        System.out.println("\nSorted by health state (dogs and cats):");
        for (Pet pet : pets) {
            System.out.println(pet.getHealthState() + " - " + (pet instanceof Dog ? "dog - " + ((Dog) pet).getSize() : "cat") + " - age " + pet.getAge() + " - " + pet.getSex());
        }
    }
}