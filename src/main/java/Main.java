public class Main {
    public static void main(String[] args) {

        ThreadGroup mainGroup = new ThreadGroup("main group");
        //ThreadGroup genericGroup=new ThreadGroup("My generic group");
        //Thread t1=new Thread(genericGroup,this);
        //1
        final MyThread myThread1 = new MyThread(mainGroup, "123");
        myThread1.setName(" Я поток 1 ");
        myThread1.start();

        //2
        final MyThread myThread2 = new MyThread(mainGroup, "123");
        myThread2.setName(" Я поток 2 ");
        myThread2.start();

        //3
        final MyThread myThread3 = new MyThread(mainGroup, "123");
        myThread3.setName(" Я поток 3 ");
        myThread3.start();

        //4
        final MyThread myThread4 = new MyThread(mainGroup, "123");
        myThread4.setName(" Я поток 4 ");
        myThread4.start();

        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        mainGroup.interrupt();

    }
}
