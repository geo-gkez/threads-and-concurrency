package threadsandconcurrency;

public class NotSynchronizedCounter1 implements Runnable{
    private static int counter = 0;
    public void run(){
        while (counter<10){
            System.out.println("["+Thread.currentThread().getName()+"] before: "+counter);
            counter++;
            System.out.println("["+Thread.currentThread().getName()+"] after: "+counter);
        }
    }

    public static void main(String[] args) {
        Thread[] threads = new Thread[3];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new NotSynchronizedCounter1(),"thread-"+i);
            threads[i].start();
        }
    }

}
