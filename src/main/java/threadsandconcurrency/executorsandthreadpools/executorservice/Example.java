package threadsandconcurrency.executorsandthreadpools.executorservice;

import java.util.concurrent.*;

public class Example {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService1 = Executors.newSingleThreadExecutor();
        executorService1.execute(() -> System.out.println("Asynchronous task 1"));

        executorService1.shutdown();

        ExecutorService executorService2 = Executors.newSingleThreadExecutor();
        Future future = executorService2.submit(()-> System.out.println("Asynchronous task 2"));
        future.get();
        executorService2.shutdown();

        ExecutorService executorService3 = Executors.newSingleThreadExecutor();
        Future future2 = executorService3.submit(new Callable(){
            @Override
            public Object call() throws Exception {
                System.out.println("Asynchronous Callable");
                return "Callable Result";
            }
        });
        System.out.println("future.get()::: "+future2.get());
        executorService3.shutdown();


    }
}
