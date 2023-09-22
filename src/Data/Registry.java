package Data;

import Essences.Animal;

import java.util.ArrayList;

public class Registry {
    private ArrayList<Animal> list = new ArrayList<>();

    public ArrayList<Animal> getList() {
        return list;
    }

    public void addToList(Animal animal) {
        this.list.add(animal);
    }

    public boolean isEmpty() {
        return this.list.isEmpty();
    }
}
