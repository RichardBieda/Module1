package Module2.Threads1;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class LatchBeispiel {

    private final static int TASKS = 5;
    private static final AtomicInteger THREAD_COUNTER = new AtomicInteger(1);

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(TASKS);
        ExecutorService executor = Executors.newFixedThreadPool(TASKS);

        Runnable worker = () -> {
                Thread.currentThread().setName("Richis Thread " + THREAD_COUNTER.getAndIncrement());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " ist fertig");
            latch.countDown();
        };

        for (int i = 0; i < TASKS; i++) {
            executor.submit(worker);
        }

        latch.await();
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.SECONDS);
    }
}
