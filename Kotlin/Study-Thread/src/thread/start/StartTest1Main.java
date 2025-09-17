package thread.start;

import static util.MyLogger.log;

import util.MyLogger;

public class StartTest1Main{

  public static void main(String[] args) {

    Thread thread = new Thread(() -> {
      for(int i = 0 ; i < 5 ; i++){
        log("value: " + i);
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      }
    });
    thread.start();
  }


}
