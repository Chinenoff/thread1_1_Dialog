import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class MyCallable implements Callable<Integer> {

    private int id;
    final private int numMessage = 5;
    final private int timeOut = 2000;

    public MyCallable(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public Integer call() throws Exception {
        int count = 0;
        try {
            for (int i = 1; i <= numMessage; i++) {
                count++;
                TimeUnit.MILLISECONDS.sleep(timeOut);
                System.out.println("Я поток " + getId() + ". Всем привет!");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.printf("Поток %s завершен\n", getId());
        }
        return count;
    }
}


/*
try {
        while(!isInterrupted()) {
        Thread.sleep(2500);
        System.out.println("Всем привет!" + getName());
        }
        } catch (InterruptedException err) {

        } finally{
        System.out.printf("%s завершен\n", getName());
        }*/
