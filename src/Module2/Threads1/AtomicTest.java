package Module2.Threads1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class AtomicTest {

    public static void main(String[] args) {

        AtomicInteger atom = new AtomicInteger(0);
        ExecutorService exe = Executors.newFixedThreadPool(4);

        Runnable run = () -> {
            for (int i = 0; i < 500; i++) {
                atom.incrementAndGet();
            }
        };

        ThreadFactory fac = (a) -> new Thread(a);

        for (int i = 0; i < 4; i++) {
            exe.submit(fac.newThread(run));
        }

        exe.shutdown();
        try {
            exe.awaitTermination(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(atom);
    }
}
