import java.time.LocalDate;

public abstract class Animal implements CommandsInterface {

    private String name;
    private LocalDate birthdate;
    private CommandsInterface commands;


    public Animal(String name, LocalDate birthdate, CommandsInterface commands) {
        this.name = name;
        this.birthdate = birthdate;
        this.commands = commands;
    }

    @Override
    public String toString() {
        return getClass().getName() + "{" +
                "Кличка: '" + name + '\'' +
                ", Знает команды: " + commands +
                ", Возраст: " + 1 +
                '}';
    }
}
