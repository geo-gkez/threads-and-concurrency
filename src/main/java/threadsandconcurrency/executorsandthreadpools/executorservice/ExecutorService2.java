package threadsandconcurrency.executorsandthreadpools.executorservice;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorService2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Set<Callable<String>> callables = new HashSet<>();
        callables.add(()->"Task 1");
        callables.add(()->"Task 2");
        callables.add(()->"Task 3");



        String result = executorService.invokeAny(callables);
        System.out.println("result:::"+result);
        executorService.shutdown();
    }
    
}
