package threadsandconcurrency.intro;

import java.util.Random;

public class BadWaitNotifyDemo {
    private static String msg;

    public static void main(String[] args) {
        Random random = new Random();
        int r = random.nextInt(5);

        Thread t1 = new Thread(()->{
            int counter = 0;
            while(msg==null){
                counter++;
                System.out.println(Thread.currentThread().getName()+": waiting..."+counter);
            }
            System.out.println(Thread.currentThread().getName()+": Received:"+msg);
            System.out.println(Thread.currentThread().getName()+": ok, finished!...");
        });

        t1.setName("thread1");

        Thread t2 = new Thread(()->{
            try {
                Thread.sleep(r*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            msg ="A message from thread2";
        });

        t1.start();
        t2.start();
    }
}
