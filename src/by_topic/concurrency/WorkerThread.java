
package by_topic.concurrency;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class WorkerThread implements Runnable {

  private String command;
  public static Map<String, String> map = new ConcurrentHashMap<>();
  private static volatile int i = 0;

  private void updateMap(String key, String value) {
    map.put(key, value);
  }

  public WorkerThread(String command) {
    this.command = command;
  }


  @Override
  public void run() {
    System.out.println(Thread.currentThread().getName() + " Start. Command = " + command);
    i++;
    updateMap(i + "", command + "");
    processCommand();
    System.out.println(Thread.currentThread().getName() + " End.");
  }

  private void processCommand() {
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  @Override
  public String toString() {
    return this.command;
  }


}
