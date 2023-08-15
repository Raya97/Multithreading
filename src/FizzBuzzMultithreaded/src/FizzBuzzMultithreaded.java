import java.util.concurrent.atomic.AtomicInteger;

public class FizzBuzzMultithreaded {
    private int n;
    private AtomicInteger counter = new AtomicInteger(1);

    public FizzBuzzMultithreaded(int n) {
        this.n = n;
    }

    public synchronized void fizz() {
        while (counter.get() <= n) {
            if (counter.get() % 3 == 0 && counter.get() % 5 != 0) {
                System.out.println("fizz");
                counter.incrementAndGet();
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public synchronized void buzz() {
        while (counter.get() <= n) {
            if (counter.get() % 5 == 0 && counter.get() % 3 != 0) {
                System.out.println("buzz");
                counter.incrementAndGet();
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public synchronized void fizzbuzz() {
        while (counter.get() <= n) {
            if (counter.get() % 3 == 0 && counter.get() % 5 == 0) {
                System.out.println("fizzbuzz");
                counter.incrementAndGet();
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public synchronized void number() {
        while (counter.get() <= n) {
            if (counter.get() % 3 != 0 && counter.get() % 5 != 0) {
                System.out.println(counter.get());
                counter.incrementAndGet();
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        int n = 15;
        FizzBuzzMultithreaded fizzBuzz = new FizzBuzzMultithreaded(n);

        Thread threadA = new Thread(fizzBuzz::fizz);
        Thread threadB = new Thread(fizzBuzz::buzz);
        Thread threadC = new Thread(fizzBuzz::fizzbuzz);
        Thread threadD = new Thread(fizzBuzz::number);

        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();

        try {
            threadA.join();
            threadB.join();
            threadC.join();
            threadD.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
