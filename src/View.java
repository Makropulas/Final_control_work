public class View {
    public static void printMenu() {
        System.out.println("\nМеню:\n" +
                "1 - Завести новое животное\n" +
                "2 - Показать список имеющихся животных\n" +
                "3 - Выход\n");
    }

    public static void printSubmenu() {
        System.out.println("\nМеню:\n" +
                "1 - Выбрать животное\n" +
                "2 - Выход  в главное меню\n");
    }

    public static void printChoiceOfPet() {
        System.out.println("\nКакое животное добавить в реестр?\n" +
                "1 - Собака\n" +
                "2 - Кошка\n" +
                "3 - Хомяк\n\n" +
                "0 - Отмена. Выход в главное меню\n");
    }

    public static void printDelimiter() {
        System.out.println("==================================================");
    }
}
