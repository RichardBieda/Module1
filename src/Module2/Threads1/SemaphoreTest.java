package Module2.Threads1;

import java.util.concurrent.Semaphore;

class SemaphoreTest {

    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(2);

        Runnable task = () -> {
            try {
                System.out.println(Thread.currentThread().getName() + " wartet...");
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName() + " ist drin");
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " verlässt den Raum");
                semaphore.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        for (int i = 0; i < 6; i++) {
            new Thread(task).start();
        }
    }
}
