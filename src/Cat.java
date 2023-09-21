import java.time.LocalDate;

public class Cat extends Pet{


    public Cat(String name, LocalDate birthdate, CommandsInterface commands) {
        super(name, birthdate, commands);
    }

    @Override
    public void getCommands() {

    }

    @Override
    public void addCommand() {

    }
}
