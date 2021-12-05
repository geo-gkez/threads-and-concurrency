package threadsandconcurrency.intro;

import java.util.Random;

public class GoodWaitNotifyDemo {

    private static String msg;

    public static void main(String[] args) {
        Object myLock = new Object();
        Random random = new Random();
        int r = random.nextInt(5);

        Thread t1 = new Thread(()->{

            synchronized (myLock){
                while (msg==null){
                    try {
                        myLock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName()+": Received:"+msg);
                System.out.println(Thread.currentThread().getName()+": ok, finished!...");
            }


        });

        t1.setName("thread1");

        Thread t2 = new Thread(()->{
            synchronized (myLock){
                try {
                    Thread.sleep(r*1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                msg ="A message from thread2";
                myLock.notify();
            }

        });

        t1.start();
        t2.start();


    }
}
