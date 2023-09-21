import java.time.LocalDate;

public class Camel extends PackAnimal{
    public Camel(String name, LocalDate birthdate, CommandsInterface commands) {
        super(name, birthdate, commands);
    }

    @Override
    public void getCommands() {

    }

    @Override
    public void addCommand() {

    }
}
