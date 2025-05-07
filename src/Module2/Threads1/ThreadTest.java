package Module2.Threads1;

import static java.lang.Thread.sleep;

class ThreadTest {

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(new MyRunnable(), "Richi");
        Thread t2 = new Thread(new MyRunnable(), "Laura");
        Thread t3 = new Thread(new MyRunnable() , "Tina");

        t1.start();
        t1.join();
        t2.start();
        t3.start();
    }

    private static class MyRunnable implements Runnable {

        @Override
        public void run() {
                for (int i = 1; i <= 10; i++) {
                    System.out.println(Thread.currentThread().getName() + " " + i);
                    try {
                        Thread.sleep(250);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
        }
    }
}
