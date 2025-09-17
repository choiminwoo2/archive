package thread.start;

import static util.MyLogger.log;

public class StartTest2Main {

  public static void main(String[] args) {

    PrintWorker a = new PrintWorker("A", 1000);
    PrintWorker b = new PrintWorker("B", 500);

    new Thread(a, "Thread-A").start();
    new Thread(b, "Thread-B").start();
  }

  static class PrintWorker implements Runnable{

    private String content;
    private int sleepMs;

    public PrintWorker(String content, int sleepMs) {
      this.content = content;
      this.sleepMs = sleepMs;
    }

    @Override
    public void run() {
      while(true){
        log(content);
        try {
          Thread.sleep(sleepMs);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      }
    }
  }


}
