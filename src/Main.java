public class Main {
    public static void main(String[] args) {
        while (true) {
            try {
                Controller.menu();
            } catch (Exception e) {
                System.out.println("\nОшибка в приложении: " + e.getMessage() + e.getClass());
                break;
            }
        }
        Model.scanner.close();
    }
}
