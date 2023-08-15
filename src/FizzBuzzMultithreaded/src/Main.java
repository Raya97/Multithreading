public class Main {
    public static void main(String[] args) {
        int n = 15;
        FizzBuzzMultithreaded fizzBuzz = new FizzBuzzMultithreaded(n);

        // Потік A для виведення "fizz"
        Thread threadA = new Thread(fizzBuzz::fizz);

        // Потік B для виведення "buzz"
        Thread threadB = new Thread(fizzBuzz::buzz);

        // Потік C для виведення "fizzbuzz"
        Thread threadC = new Thread(fizzBuzz::fizzbuzz);

        // Потік D для виведення чисел
        Thread threadD = new Thread(fizzBuzz::number);

        // Запускаємо всі потоки
        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();

        try {
            // Очікуємо завершення всіх потоків
            threadA.join();
            threadB.join();
            threadC.join();
            threadD.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
