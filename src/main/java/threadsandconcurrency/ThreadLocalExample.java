package threadsandconcurrency;

public class ThreadLocalExample {
    public static class MyRunnable implements Runnable{

        private ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

        @Override
        public void run() {
                        threadLocal.set((int) (Math.random()*100D));
                        try {
                            Thread.sleep(5000);
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
            System.out.println(threadLocal.get());
        }
    }


    public static void main(String[] args) {
        MyRunnable sharedRunnableInstance = new MyRunnable();
        Thread t1 = new Thread(sharedRunnableInstance);
        Thread t2 = new Thread(sharedRunnableInstance);
        t1.start();
        t2.start();
        try {
            t1.join(); // wait for thread 1 to terminate
            t2.join(); // wait for thread 2 to terminate
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }


}
