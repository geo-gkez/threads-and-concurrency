package threadsandconcurrency;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MainThread1 {
    public static void main(String[] args) {


        long id = Thread.currentThread().getId();
        String name = Thread.currentThread().getName();
        int priority = Thread.currentThread().getPriority();
        Thread.State state = Thread.currentThread().getState();
        String threadGroupName = Thread.currentThread().getThreadGroup().getName();
        System.out.println("id::"+id+",\n name::"+name+",\n priority::"+priority
        +",\n state::"+state+",\n threadGroupName::"+threadGroupName);

        System.out.println("###############");
        Thread mt2 = new Thread(new MyRunnable());
        mt2.start();
        System.out.println("###############");
        Thread t = new Thread(() -> System.out.println("hi"));
        t.start();


    }

}

class MySimpleThread extends Thread{
    public static void main(String[] args) {
        MySimpleThread mt = new MySimpleThread();
        mt.start();
    }
    public void run(){
        System.out.println("Hello from MySimpleThread");
    }
}

class MySimpleThread2 extends Thread{
    public static void main(String[] args) {
        MySimpleThread2 mt2 = new MySimpleThread2();
        mt2.start();
    }
    public void run(){
       IntStream.range(0,11).boxed().collect(Collectors.toList())
        .forEach(x->{
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(x+" Hello from MySimpleThread2");
        });

    }
}

 class MyRunnable implements Runnable{

    public void run(){
        System.out.println("hi from MyRunnable");
    }
}