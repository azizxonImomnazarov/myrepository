public class Main {
    public static void main(String[] args) {
        Bankomat bankomat = new Bankomat();
        Thread thread1 = new Thread(() -> {
            bankomat.gettingMoney("Azizxon");
        });
        Thread thread2 = new Thread(() -> {
            bankomat.gettingMoney("Lazizxon");
        });
        Thread thread3 = new Thread(() -> {
            bankomat.gettingMoney("Azimxon");
        });
        Thread thread4 = new Thread(() -> {
            bankomat.gettingMoney("Davron");
        });

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(bankomat.getMoney());

    }
}
