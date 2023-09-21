import java.time.LocalDate;
import java.util.ArrayList;

public class Horse extends PackAnimal {
    public Horse(String name, LocalDate birthdate, CommandsInterface commands) {
        super(name, birthdate, commands);
    }

    public Horse() {
        super("Ally", LocalDate.of(2020, 10, 20), new Horse());
    }

    @Override
    public void getCommands() {

    }

    @Override
    public void addCommand() {

    }
}
