public class MyThread extends Thread{
    //private int threadID;

   /* public MyThread(int threadID) {
        this.threadID = threadID;
    }*/

    // constructor of the  class


    public MyThread(ThreadGroup group, String name) {
        super(group, name);
    }

    @Override
    public void run() {
        try {
            while(!isInterrupted()) {
                Thread.sleep(2500);
                System.out.println("Всем привет!" + getName());
            }
        } catch (InterruptedException err) {

        } finally{
            System.out.printf("%s завершен\n", getName());
        }
    }
}
