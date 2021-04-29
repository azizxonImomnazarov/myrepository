public class Task10 {

    public static void main(String[] args) {
        Printer printer = new Printer();
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                printer.printA();
            }).start();

            new Thread(() -> {
                printer.printB();
            }).start();

            new Thread(() -> {
                printer.printC();
            }).start();
        }
    }
}
