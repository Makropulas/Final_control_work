import java.time.LocalDate;

public class Dog extends Pet{

    public Dog(String name, LocalDate birthdate, CommandsInterface commands) {
        super(name, birthdate, commands);
    }

    @Override
    public void getCommands() {

    }

    @Override
    public void addCommand() {

    }
}
