import java.time.LocalDate;

public class Donkey extends PackAnimal{
    public Donkey(String name, LocalDate birthdate, CommandsInterface commands) {
        super(name, birthdate, commands);
    }

    @Override
    public void getCommands() {

    }

    @Override
    public void addCommand() {

    }
}
