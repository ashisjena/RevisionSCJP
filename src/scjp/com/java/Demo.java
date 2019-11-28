package scjp.com.java;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class Demo {
  public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
    /*Callable<String> callable1 = () -> {
      Thread.sleep(10000);
      return Thread.currentThread().getName();
    };
    Callable<String> callable2 = () -> {
      Thread.sleep(1);
      return Thread.currentThread().getName();
    };


    ExecutorService es = Executors.newFixedThreadPool(2);
    List<Future<String>> fList = es.invokeAll(Arrays.asList(callable1, callable2));
    System.out.println(fList.get(0).get());
    System.out.println(fList.get(1).get());
    *//*Future<String> future1 = es.submit(callable1);
    Future<String> future2 = es.submit(callable1);
    future1.get(10, TimeUnit.MILLISECONDS);
    future2.get(10, TimeUnit.MILLISECONDS);*//*

    System.out.println("--------------------------");
    *//*CompletionService cs = new ExecutorCompletionService(es);
    cs.submit(callable1);
    cs.submit(callable2);
    System.out.println(cs.take().get());
    System.out.println(cs.take().get());*//*

    es.shutdown();*/

    System.out.println(7 >>> 1);
  }
}
