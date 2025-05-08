package Module2.Threads1;

import java.util.concurrent.*;

public class CallableAndFuture {

     static void main(String[] args) throws Exception {

        ExecutorService executor = Executors.newSingleThreadExecutor();

        Callable<Integer>  callable = () -> {
            int result = 0;
            for (int i = 1; i <= 100; i++) {
                result += i;
            }
            return result;
        };

        Future<Integer> future = executor.submit(callable);

        System.out.println(future.get());
        executor.shutdown();
        executor.awaitTermination(1,TimeUnit.SECONDS);
    }
}
