package hu.nive.ujratervezes.zarovizsga.kennel;

import java.util.ArrayList;
import java.util.List;

public class Kennel {

    private List<Dog> dogs = new ArrayList<>();

    public List<Dog> getDogs() {
        return List.copyOf(dogs);
    }

    public void addDog(Dog dog) {
      dogs.add(dog);
    }

    public void feedAll() {
        for (Dog item : dogs) {
            item.feed();
        }
    }

    public Dog findByName(String name) {
        for (Dog item : dogs) {
            if (item.getName().equals(name)) {
                return item;
            }
        }
        throw new IllegalArgumentException("Can't find the dog.");
    }

    public void playWith(String name, int hours) {
        Dog dog = findByName(name);
        dog.play(hours);
    }

    public List<String> getHappyDogNames(int minHappiness) {
        List<String> dogNames = new ArrayList<>();
        for (Dog item : dogs) {
            if (item.getHappiness() > minHappiness) {
                dogNames.add(item.getName());
            }
        }
        return dogNames;
    }

}
