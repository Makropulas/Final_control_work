package Essences;

import Data.Commands;

import java.time.LocalDate;

public abstract class Animal extends Commands {

    private final String name;
    private final LocalDate birthdate;
    private Commands commands;


    public Animal(String name, LocalDate birthdate, Commands commands) {
        this.name = name;
        this.birthdate = birthdate;
        this.commands = commands;
    }

    public Animal(String name, LocalDate birthdate) {
        this.name = name;
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        return getClass().getName() + "{" +
                "Кличка: '" + name + '\'' +
                ", Знает команды: " + commands +
                ", Дата рождения: " + birthdate +
                '}';
    }
}
