package Essences;

import java.time.LocalDate;

public class Dog extends Pet{

    public Dog(String name, LocalDate birthdate) {
        super(name, birthdate);
    }

    @Override
    public String getClassname() {
        return "Собака";
    }
}
