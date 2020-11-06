package by_topic.concurrency;

public class ProducerConsumerFromMyBlockingQueue {

  public static void main(String args[]){

    //Creating shared object
    MyBlockingQueue sharedQueue = new MyBlockingQueue(10);

    //Creating Producer and Consumer Thread
    Thread prodThread = new Thread(new Producer(sharedQueue));
    Thread consThread = new Thread(new Consumer(sharedQueue));
    Thread cons01Thread = new Thread(new Consumer(sharedQueue));
    Thread cons02Thread = new Thread(new Consumer(sharedQueue));
    Thread cons03Thread = new Thread(new Consumer(sharedQueue));
    Thread cons04Thread = new Thread(new Consumer(sharedQueue));

    //Starting producer and Consumer thread
    prodThread.start();
    consThread.start();
    cons01Thread.start();
    cons02Thread.start();
    cons03Thread.start();
   // cons04Thread.start();
  }

  static class Producer implements Runnable {

    private final MyBlockingQueue sharedQueue;

    public Producer(MyBlockingQueue sharedQueue) {
      this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
      for(int i=0; i<50; i++){
        try {
          Thread.sleep( 1000 );
          System.out.println("Produced: " + i);
          sharedQueue.enqueue( i);
        } catch (InterruptedException ex) {
          //Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
    }

  }

  //Consumer Class in Java
  static class Consumer implements Runnable{

    private final MyBlockingQueue sharedQueue;

    public Consumer (MyBlockingQueue sharedQueue) {
      this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
      while(true){
        try {
          Thread.sleep( 2000 );
          System.out.println("Consumed By : " + Thread.currentThread().getName() + " -- " +  sharedQueue.dequeue());
        } catch (InterruptedException ex) {
          //Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
    }
  }

}
