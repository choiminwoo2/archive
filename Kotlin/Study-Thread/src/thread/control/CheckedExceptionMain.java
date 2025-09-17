package thread.control;

import static util.ThreadUtils.sleep;

import util.ThreadUtils;

public class CheckedExceptionMain {

  public static void main(String[] args) throws Exception {

  }

  static class CheckedRunnable implements Runnable {

    public void run() {
      sleep(1000);
    }
  }
}
