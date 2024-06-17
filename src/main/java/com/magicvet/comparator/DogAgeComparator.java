package main.java.com.magicvet.comparator;

import main.java.com.magicvet.model.Dog;
import java.util.Comparator;

public class DogAgeComparator implements Comparator<Dog> {

    @Override
    public int compare(Dog dog1, Dog dog2) {
        return convertAge(dog1.getAge()) - convertAge(dog2.getAge());
    }

    private static int convertAge(String age) {
        try {
            return Integer.parseInt(age);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
