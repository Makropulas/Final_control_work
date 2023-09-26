package Essences;

import java.time.LocalDate;

public class Hamster extends Pet {

    public Hamster(String name, LocalDate birthdate) {
        super(name, birthdate);
    }

    @Override
    public String getClassname() {
        return "Хомяк";
    }
}
