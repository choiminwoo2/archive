package org.ruu.advanced.logtrace;

import org.junit.jupiter.api.Test;
import org.ruu.advanced.app.trace.TraceStatusV1;

public class ThreadLocalLogTraceTest {

  ThreadLocalLogTrace trace = new ThreadLocalLogTrace();
  @Test
  void begin_end_level2() {
    TraceStatusV1 status1 = trace.begin("hello1");
    TraceStatusV1 status2 = trace.begin("hello2");
    trace.end(status2);
    trace.end(status1);
  }
  @Test
  void begin_exception_level2() {
    TraceStatusV1 status1 = trace.begin("hello");
    TraceStatusV1 status2 = trace.begin("hello2");
    trace.exception(status2, new IllegalStateException());
    trace.exception(status1, new IllegalStateException());
  }
}
