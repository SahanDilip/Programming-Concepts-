public class Test10 {
    public static void main(String[] args) throws Exception  {
        Hi obj1 = new Hi();
        Hellow obj2 = new Hellow();
        Thread t1 = new Thread(obj1 );
        Thread t2 = new Thread(obj2);


        t1.setPriority(1);
        t2.setPriority(10);
        t1.start();
        try {Thread.sleep(100);}catch (InterruptedException e){}
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Bye");
    }
 }
class Hellow implements Runnable{
    public void run(){
        for(int i = 0; i<5; i++){
            System.out.println("Hellow");
            try {Thread.sleep(500);}catch (InterruptedException e){}
        }
    }

}
class Hi implements Runnable {
    public void run(){
        for(int i = 0; i<5; i++){
            System.out.println("Hi");
            try {Thread.sleep(500);}catch (InterruptedException e){  }
        }
    }

}