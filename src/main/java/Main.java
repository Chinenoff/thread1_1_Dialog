import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        final int countMyCallable = 4;

        ExecutorService executorService =
                Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        //Создание и запуск одной задачи
        //final MyCallable myCallable = new MyCallable();
        //Future<Integer> future = executorService.submit(myCallable);
        //System.out.println(future);
        //executorService.shutdown();


        //Создание и запуск нескольких задач invokeAll

        // List<Future<Integer>> futures = executorService.invokeAll(callableTasks
        // (countMyCallable));
        //for (Future<Integer> result : futures
        //) {
        //    System.out.println("выведенных в консоль сообщений:" + result.get());
        //}
        //executorService.shutdown();

        //Создание и запуск нескольких задач invokeAny
        Integer result = executorService.invokeAny(callableTasks(countMyCallable));
        System.out.println(" выведенных в консоль сообщений:" + result);
        executorService.shutdown();
    }

    public static List<Callable<Integer>> callableTasks(int countMyCallable) {
        List<Callable<Integer>> callableTasks = new ArrayList<>();
        for (int i = 1; i <= countMyCallable; i++) {
            MyCallable myCallable = new MyCallable(i);
            callableTasks.add(myCallable);
        }
        return callableTasks;
    }
}
