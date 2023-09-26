import Essences.Animal;

public class Controller {
    private static final Registry registry = new Registry();

    public static void menu() {
        View.printMenu();
        switch (Model.action("[012]")) {
            case 1:
                View.printChoiceOfPet();
                int num = Model.action("[0123]");
                if (num == 0) break;
                Animal animal = Model.choiceOfPet(num);
                if (animal != null) {
                    registry.addAnimal(animal);
                    System.out.println("\n>>> Запись добавлена <<<\n");
                } else System.out.println("\n>>> Нет такой команды <<<\n");
                Model.waitingForInput();
                break;
            case 2:
                if (registry.isEmpty()) {
                    View.printSmallDelimiter();
                    System.out.println("\n>>> Реестр пуст. Выход в главное меню <<<\n");
                    Model.waitingForInput();
                } else {
                    submenu();
                }
                break;
            case 0:
                System.exit(0);
        }
    }

    public static void submenu() {
        View.printBigDelimiter();
        System.out.println("В реестре числятся следующие животные:\n");
        registry.printRegistry();
        View.printSubmenu();
        int id;
        switch (Model.action("[012]")) {
            case 1:
                id = Model.enterID(registry);
                petMenu(id);
                submenu();
                break;
            case 2:
                id = Model.enterID(registry);
                registry.deleteAnimal(id);
                System.out.println("\n>>> Запись удалена <<<\n");
                Model.waitingForInput();
                submenu();
                break;
            case 0:
                break;
        }
    }

    public static void petMenu(int id) {
        View.printBigDelimiter();
        System.out.println(registry.getAnimal(id));
        View.printPetMenu();
        switch (Model.action("[01]")) {
            case 1:
                View.printSmallDelimiter();
                String command = Model.enterCommand();
                registry.getAnimal(id).addCommand(command);
                System.out.println("\n>>> Команда '" + command + "' изучена <<<\n");
                Model.waitingForInput();
                petMenu(id);
                break;
            case 0:
                break;
        }
    }
}
