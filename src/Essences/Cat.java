package Essences;

import java.time.LocalDate;

public class Cat extends Pet{


    public Cat(String name, LocalDate birthdate) {
        super(name, birthdate);
    }


    @Override
    public String getClassname() {
        return "Кошка";
    }
}
