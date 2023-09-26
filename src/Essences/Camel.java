package Essences;

import java.time.LocalDate;

public class Camel extends PackAnimal {
    public Camel(String name, LocalDate birthdate) {
        super(name, birthdate);
    }

    @Override
    public String getClassname() {
        return "Верблюд";
    }
}
