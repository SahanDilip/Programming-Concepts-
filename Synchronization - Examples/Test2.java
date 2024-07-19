public class Test2{
    public static void main(String[] args) {
        B obj1 = new B();
        Thread tob = new Thread(obj1);
        tob.start(); //start method is in Thread class So, we cant call this method by implementing runnable  interface
        C obj2 = new C(); // So we create thread class object and pass the object of the class to the parameter then Thread obj is created
        Thread tob2 = new Thread(obj2); // using it we can call the start method
        tob2.start();
    }
}
class  B implements Runnable{
    public void run() {
        for(int i =0; i<=10; i++){
            try {
                System.out.println("Hellow ");
                Thread.sleep(500);
            } catch (InterruptedException e) {}
        }
    }
}

class C implements Runnable{
    public void run(){
        for(int i =0; i<=10; i++){
            try {
                System.out.println("world");
                Thread.sleep(500);
            } catch (InterruptedException e) {}
        }
    }
}


