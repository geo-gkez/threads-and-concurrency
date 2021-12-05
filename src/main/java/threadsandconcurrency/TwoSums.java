package threadsandconcurrency;

public class TwoSums {
   private  int sum1=0;
   private  int sum2=0;

   private Integer sum1Lock = Integer.valueOf(1);
   private Integer sum2Lock = Integer.valueOf(2);

    public static void main(String[] args) {

       TwoSums twoSums = new TwoSums();
       twoSums.add1(1,2);
        System.out.println("sum1::"+twoSums.sum1);
        System.out.println("sum2::"+twoSums.sum2);

        TwoSums twoSums2 = new TwoSums();
        twoSums.add2(1,2);
        System.out.println("sum1 add2::"+twoSums2.sum1);
        System.out.println("sum2 add2::"+twoSums2.sum2);

    }

    public void add1(int val1,int val2){
    synchronized (this){
            this.sum1 += val1;
            this.sum2 += val2;
        }
    }

    public void add2(int val1,int val2){
        synchronized (this.sum1Lock){
            this.sum1 += val1;
        }
        synchronized (this.sum2Lock){
            this.sum2 += val2;
        }


    }






}
