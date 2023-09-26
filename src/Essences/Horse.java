package Essences;

import java.time.LocalDate;

public class Horse extends PackAnimal {
    public Horse(String name, LocalDate birthdate) {
        super(name, birthdate);
    }

    @Override
    public String getClassname() {
        return "Лошадь";
    }
}
