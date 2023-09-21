import java.time.LocalDate;

public abstract class PackAnimal extends Animal {

    public PackAnimal(String name, LocalDate birthdate, CommandsInterface commands) {
        super(name, birthdate, commands);
    }
}
