public class Main {
    public static void main(String[] args) {
        // Потік для виведення часу кожну секунду
        Thread timeThread = new Thread(() -> {
            while (true) {
                // Отримуємо поточний час в мілісекундах і перетворюємо його на секунди
                long пройшло_часу_в_секундах = System.currentTimeMillis() / 1000;
                System.out.println("Пройшло часу: " + пройшло_часу_в_секундах + " секунд");

                try {
                    // Призупиняємо потік на 1 секунду
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Потік для виведення сповіщення кожні 5 секунд
        Thread notificationThread = new Thread(() -> {
            while (true) {
                System.out.println("Пройшло 5 секунд");

                try {
                    // Призупиняємо потік на 5 секунд
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Запускаємо обидва потоки
        timeThread.start();
        notificationThread.start();
    }
}
