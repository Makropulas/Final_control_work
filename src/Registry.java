import Essences.Animal;

import java.util.HashMap;
import java.util.Map;

public class Registry {
    private final HashMap<Integer, Animal> animalsMap = new HashMap<>();

    private int id = 1;

    public Animal getAnimal(int id) {
        return animalsMap.get(id);
    }

    public void printRegistry() {
        for (Map.Entry<Integer, Animal> item : animalsMap.entrySet()) {
            System.out.printf("ID: %d | %s: %s Возраст: %s Знает команд: %d\n", item.getKey(), item.getValue().getClassname(),
                    item.getValue().getName(), item.getValue().getAge(), item.getValue().getNumberOfCommands());
        }
    }

    public boolean checkID(int id) {
        return animalsMap.containsKey(id);
    }

    public void addAnimal(Animal animal) {
        animalsMap.put(generateId(), animal);
    }

    public void deleteAnimal(int id) {
        animalsMap.remove(id);
    }

    public boolean isEmpty() {
        return animalsMap.isEmpty();
    }

    private int generateId() {
        return id++;
    }
}
