package Module2.Threads1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

class SynchroTest {

    static int counterOhneLock = 0;
    static int counterMitLock = 0;
    final static Object lock = new Object();

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(5);

        Runnable runOhneLock = () -> {
            for (int i = 0; i < 100; i++) {
                counterOhneLock++;
            }
        };

        Runnable runMitLock = () -> {
            synchronized (lock) {
                for (int i = 0; i < 100; i++) {
                    counterMitLock++;
                }
            }
        };

        executor.submit(runOhneLock);
        executor.submit(runOhneLock);
        executor.submit(runMitLock);
        executor.submit(runMitLock);


        try {
            executor.shutdown();
            executor.awaitTermination(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(counterOhneLock);
        System.out.println(counterMitLock);
    }
}
