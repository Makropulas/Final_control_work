import Data.Registry;
import Essences.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Controller {
    static Scanner scanner = new Scanner(System.in);
    private static Registry registry = new Registry();

    public static void menu() {
        View.printMenu();
        switch (action()) {
            case 1:
                View.printChoiceOfPet();
                int num = action();
                if (num == 0) break;
                Animal animal = choiceOfPet(num);
                if (animal != null)
                    registry.addToList(animal);
                waitingForInput();
                break;
            case 2:
                if (registry.isEmpty()) {
                    System.out.println("Реестр пуст. Выход в главное меню\n");
                } else {
                    registry.getList();
                    submenu();
                }
                waitingForInput();
                break;
            case 3:
                System.exit(0);
        }
    }

    public static void submenu() {
        View.printSubmenu();
        switch (action()) {
            case 1:
                View.printChoiceOfPet();
                int num = action();
                if (num == 0) break;
                Animal animal = choiceOfPet(num);
                if (animal != null)
                    registry.addToList(animal);
                waitingForInput();
                break;
            case 2:
                if (registry.isEmpty()) {
                    System.out.println("Реестр пуст. Выход в главное меню\n");
                }
                waitingForInput();
                break;
            case 3:
                System.exit(0);
        }
    }

    public static Animal choiceOfPet(int action) {
        Animal animal = null;
        switch (action) {
            case 1:
                System.out.println("Заводим в реестр кошку\n");
                View.printDelimiter();
                animal = new Cat(inputNameOfAnimal(), inputBirthdateOfAnimal());
                break;
            case 2:
                System.out.println("Заводим в реестр собаку\n");
                View.printDelimiter();
                animal = new Dog(inputNameOfAnimal(), inputBirthdateOfAnimal());
                break;
            case 3:
                System.out.println("Заводим в реестр хомяка\n");
                View.printDelimiter();
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
        System.out.print("Введите дату рождения (в формате ДД ММ ГГГГ): ");
        return LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd MM yyyy"));
    }

    public static int action() {
        System.out.print("Введите номер действия: ");
        if (scanner.hasNextInt()) {
            return scanner.nextInt();
        } else {
            scanner.next();
            return action();
        }
    }

    public static void waitingForInput() {
        System.out.println("\nДля продолжения нажмите Enter ");
        scanner.next();
    }

}
