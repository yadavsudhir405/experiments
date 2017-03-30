package github.com.yadavsudhir405.experiments.coreJavaPractise.concurrency;

/**
 * @author sudhir
 *         Date:30/3/17
 *         Time:11:42 AM
 *         Project:core-java-practise
 */
public class PrintingOddEvenNumber {



    public static void main(String[] args) throws InterruptedException {
        Displayer displayer=new Displayer();
        Thread p1=new Thread(new OddNumberProducer(displayer),"OddProducer");
        Thread p2=new Thread(new EvenNumberProducer(displayer),"EvenProducer");
        p2.start();
        p1.start();



    }
    private static class OddNumberProducer implements Runnable{
        private final Displayer displayer;

        public OddNumberProducer(Displayer displayer) {
            this.displayer = displayer;
        }

        @Override
        public void run() {
            for(int i=1;i<=9;i=i+2){
                displayer.display(i);
            }
        }
    }

    private static class EvenNumberProducer implements Runnable{
        private final Displayer displayer;

        public EvenNumberProducer(Displayer displayer) {
            this.displayer = displayer;
        }

        @Override
        public void run() {
            for(int i=2;i<=10;i=i+2){
                    displayer.display(i);
            }
        }
    }

    private static class Displayer {
        private boolean isOddTurn=true;
        private boolean isEvenTurn=false;
        public  void display(int i){
           synchronized (this){
               while(i%2!=0&&! isOddTurn){
                   try {
                       this.wait();
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
               while(i%2==0&& !isEvenTurn){
                   try {
                       this.wait();
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
               System.out.println(i+" by "+Thread.currentThread().getName());
               if(i%2==0){
                   isOddTurn=true;
                   isEvenTurn=false;
                   this.notify();
               }else{
                   isOddTurn=false;
                   isEvenTurn=true;
                   this.notify();
               }
           }

        }

    }
}
