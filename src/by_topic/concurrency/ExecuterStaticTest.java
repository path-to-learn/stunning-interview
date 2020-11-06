package by_topic.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecuterStaticTest {

  /**
   * @param args
   * @throws InterruptedException
   */
  public static void main(String[] args) throws InterruptedException {
    ExecutorService executor = Executors.newFixedThreadPool(3);
    for (int i = 0; i < 5; i++) {
      Runnable worker = new WorkerThread("" + i);
      Thread.sleep(1000);
      executor.execute(worker);
    }
    executor.shutdown();
    while (!executor.isTerminated()) {
      // .out.println("Finishing the threads...");
    }
    System.out.println("Map size finally is: " + WorkerThread.map.size());
    System.out.println("Finsihed all threads");
  }

}
