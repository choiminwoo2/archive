package thread.start;

import static util.MyLogger.log;

import util.MyLogger;

public class InnerRunnableMainV1 {

  public static void main(String[] args) {
    log("main() start");
    InnerRunnable innerRunnable = new InnerRunnable();
    Thread thread = new Thread(innerRunnable);
    thread.start();

    log("main() end");
  }

  static class InnerRunnable implements Runnable {
    public void run() {
      log("run()");
    }
  }
}
