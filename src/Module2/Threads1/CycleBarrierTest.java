package Module2.Threads1;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class CycleBarrierTest {

    private static final int THREAD_COUNT = 4;

    public static void main(String[] args) {

        CyclicBarrier barrier = new CyclicBarrier(THREAD_COUNT, () -> {
            System.out.println("Alle bereit - Rennen startet!");
        });

        Runnable task = () -> {
            System.out.println(Thread.currentThread().getName() + " vor der Barriere");
            try {
                Thread.sleep((long) (Math.random() * 2000));
                barrier.await();
                System.out.println(Thread.currentThread().getName() + " läuft los");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
        };

        for (int i = 0; i < THREAD_COUNT; i++) {
            new Thread(task).start();
        }
    }
}
