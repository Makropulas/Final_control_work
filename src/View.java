public class View {
    public static void printMenu() {
        printBigDelimiter();
        System.out.println("""
                Меню:
                1 - Завести новое животное
                2 - Показать список имеющихся животных
                0 - Выход
                """);
    }

    public static void printSubmenu() {
        printSmallDelimiter();
        System.out.println("""
                Меню:
                1 - Открыть запись о животном
                2 - Удалить запись из реестра
                0 - Выход  в главное меню
                """);
    }

    public static void printPetMenu() {
        printSmallDelimiter();
        System.out.println("""
                Меню:
                1 - Обучить животное новой команде
                0 - Выход из карточки животного
                """);
    }

    public static void printChoiceOfPet() {
        printSmallDelimiter();
        System.out.println("""
                Какое животное добавить в реестр?

                1 - Кошка
                2 - Собака
                3 - Хомяк

                0 - Отмена. Выход в главное меню
                """);
    }

    public static void printBigDelimiter() {
        System.out.println("\n==================================================\n");
    }

    public static void printSmallDelimiter() {
        System.out.println("\n--------------------------------------------------\n");
    }
}
