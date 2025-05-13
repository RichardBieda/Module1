package Module2;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

class ThreadTestHomework {

    private final static int MAX_COUNT = 1_000_000;
    //1_000_000 = 1784293664; 100_000 = 705082704; 10_000 = 50005000; 1_000 = 500500
    //1 million should be 500000500000 and 1 hundred thousand 5000050000
    //The reason for the wrong values is an Integer overflow
    private final static int[] ARR = new int[MAX_COUNT];
    private final static int[] TRIES = {10, 8, 5, 4, 2, 1};

    static {
        for (int i = 1; i <= MAX_COUNT; i++) {
            ARR[i-1] = i;
        }
    }

    static void compareThreadEfficiency(int threadCount) {
        long start = System.nanoTime();
        //AtomicInteger for separating ARR array in smaller arrays for each thread
        final AtomicInteger sum = new AtomicInteger(0);
        final AtomicInteger from = new AtomicInteger(0);
        final AtomicInteger to = new AtomicInteger(0);
        final AtomicInteger counter = new AtomicInteger(0);//this variable replaces the i in the following loop
        final Thread[] threads = new Thread[threadCount];

        //Thread creating in a loop
        for (int i = 0; i < threadCount; i++) {
            Thread t = new Thread(() -> {
                from.set(counter.get() * (MAX_COUNT / threadCount));
                to.set(counter.incrementAndGet() * (MAX_COUNT / threadCount));
                int[] tmpArray = Arrays.copyOfRange(ARR, from.get(), to.get());
                int threadResult = 0;
                for (int k : tmpArray) {
                    threadResult += k;
                }
                sum.addAndGet(threadResult);
            });
            threads[i] = t;
            t.start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        long end = System.nanoTime();
        System.out.println("duration: " + (end - start) + ", sum: " + sum.get() + ", threadCount: " + threadCount);
    }

    public static void main(String[] args) {
        for (int aTry : TRIES) {
            compareThreadEfficiency(aTry);
        }
    }
}
