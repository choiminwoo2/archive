package thread.control.interrupt;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

import util.MyLogger;
import util.ThreadUtils;

public class ThreadStopMainV1 {

  public static void main(String[] args) {
    MyTask task = new MyTask();
    Thread thread = new Thread(task);
    thread.start();

    sleep(40000);
    log("작업 중단 지시 runflag = false");
    task.runflag = false;
  }

  static class MyTask implements Runnable {

    volatile boolean runflag = true;

    public void run() {
      while(runflag) {
        log("작업 중");
        sleep(3000);
      }
      log("작업정리");
      log("작업끝");
    }
  }

}
