import java.time.LocalDate;

public class Hamster extends Pet{

    public Hamster(String name, LocalDate birthdate, CommandsInterface commands) {
        super(name, birthdate, commands);
    }

    @Override
    public void getCommands() {

    }

    @Override
    public void addCommand() {

    }
}
