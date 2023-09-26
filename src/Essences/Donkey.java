package Essences;

import java.time.LocalDate;

public class Donkey extends PackAnimal {
    public Donkey(String name, LocalDate birthdate) {
        super(name, birthdate);
    }

    @Override
    public String getClassname() {
        return "Осёл";
    }
}
