import Essences.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Model {
    static Scanner scanner = new Scanner(System.in);

    public static Animal choiceOfPet(int action) {
        Animal animal = null;
        switch (action) {
            case 1:
                View.printBigDelimiter();
                System.out.println("Заводим в реестр кошку\n");
                animal = new Cat(inputNameOfAnimal(), inputBirthdateOfAnimal());
                break;
            case 2:
                View.printBigDelimiter();
                System.out.println("Заводим в реестр собаку\n");
                animal = new Dog(inputNameOfAnimal(), inputBirthdateOfAnimal());
                break;
            case 3:
                View.printBigDelimiter();
                System.out.println("Заводим в реестр хомяка\n");
                animal = new Hamster(inputNameOfAnimal(), inputBirthdateOfAnimal());
                break;
            default:
                break;
        }
        return animal;
    }

    public static String inputNameOfAnimal() {
        System.out.print("Введите имя: ");
        return scanner.nextLine();
    }

    public static LocalDate inputBirthdateOfAnimal() {
        LocalDate localDate = null;
        while (localDate == null) {
            try {
                System.out.print("Введите дату рождения (в формате ДД ММ ГГГГ): ");
                localDate = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd MM yyyy"));
            } catch (RuntimeException e) {
                System.out.println("\n>>> Неверный формат ввода даты. Введите дату соответственно григорианскому календарю <<<\n");
            }
        }
        return localDate;
    }

    public static int enterID(Registry registry) {
        int id;
        while (true) {
            String message = "Введите ID: ";
            id = getIntFromConsole(message);
            if (registry.checkID(id)) {
                break;
            } else {
                System.out.println("\n>>> Запись с таким ID отсутствует <<<\n");
            }
        }
        return id;
    }

    public static String enterCommand() {
        System.out.print("Введите команду: ");
        return scanner.nextLine();
    }

    public static int action(String regex) {
        int i;
        while (true) {
            String message = "Введите номер действия: ";
            i = getIntFromConsole(message);
            String iString = String.valueOf(i);
            if (iString.matches(regex)) {
                break;
            }
        }
        return i;
    }

    public static int getIntFromConsole(String message) {
        int i;
        while (true) {
            System.out.print(message);
            try {
                i = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException ignored) {
            }
        }
        return i;
    }

    public static void waitingForInput() {
        System.out.print("\nДля продолжения нажмите Enter ");
        boolean pass = Boolean.parseBoolean(scanner.nextLine());
    }
}
