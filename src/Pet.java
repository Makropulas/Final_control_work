import java.time.LocalDate;

public abstract class Pet extends Animal {

    public Pet(String name, LocalDate birthdate, CommandsInterface commands) {
        super(name, birthdate, commands);
    }
}
