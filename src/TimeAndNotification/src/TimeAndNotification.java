import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TimeAndNotification {
    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);

        Runnable timeTask = () -> {
            SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
            System.out.println("Current time: " + dateFormat.format(new Date()));
        };
        executor.scheduleAtFixedRate(timeTask, 0, 1, TimeUnit.SECONDS);

        Runnable notificationTask = () -> System.out.println("Прошло 5 секунд");
        executor.scheduleAtFixedRate(notificationTask, 0, 5, TimeUnit.SECONDS);
    }
}
