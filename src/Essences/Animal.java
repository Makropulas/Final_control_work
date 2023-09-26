package Essences;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public abstract class Animal implements ClassnameInterface {

    private final String name;
    private final LocalDate birthdate;
    private ArrayList<String> commands = new ArrayList<>();

    public String getName() {
        return name;
    }

    public String getBirthdate() {
        return String.format("%d.%d.%d", birthdate.getDayOfMonth(), birthdate.getMonthValue(), birthdate.getYear());
    }

    public String getAge() {
        String age;
        long ageMonth = ChronoUnit.MONTHS.between(birthdate, LocalDate.now());
        if (ageMonth >= 12) {
            long years = ageMonth / 12;
            long month = ageMonth - (years * 12);
            age = String.format(years + " г. " + month + " мес.");
        } else {
            age = String.format(ageMonth + " мес.");
        }
        return age;
    }

    public Animal(String name, LocalDate birthdate) {
        this.name = name;
        this.birthdate = birthdate;
    }

    public void addCommand(String command) {
        commands.add(command);
    }

    public String getCommands() {
        return String.join(", ", commands);
    }

    @Override
    public String toString() {
        if (commands.isEmpty()) {
            return getClassname() +
                    " по кличке '" + name +
                    "'\nКоманды пока не изучены" +
                    "\nДата рождения: " + getBirthdate();
        } else {
            return getClassname() +
                    " по кличке '" + name +
                    "'\nЗнает команды: " + getCommands() +
                    "\nДата рождения: " + getBirthdate();
        }
    }
}
