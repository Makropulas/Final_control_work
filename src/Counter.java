public class Counter implements AutoCloseable {
    private int count = 0;

    public void add() {
        count++;
    }

    @Override
    public void close() {
        System.out.println("\n>>> Счётчик закрыт <<<\n");
    }
}
