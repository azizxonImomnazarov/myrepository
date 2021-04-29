public class Bankomat {
    final Object monitor = new Object();
    private int money = 100000;

    public void gettingMoney(String name) {
        synchronized (this) {
            try {
                System.out.println(name + " is came to Bankomat");
                Thread.sleep(2000);
                int minusMoney = 33000;
                if (this.money - minusMoney > 0) {
                    this.money -= minusMoney;
                    System.out.println(minusMoney + " is Getting in Bankomat all money " + this.money);
                } else {
                    System.out.println("Bankomat isn't has enough money");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int getMoney() {
        return money;
    }
}
