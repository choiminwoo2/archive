package org.ruu.advanced.trace.v1.hellotrace;

import org.junit.jupiter.api.Test;
import org.ruu.advanced.app.trace.helloTrace.HelloTraceV1;
import org.ruu.advanced.app.trace.TraceStatusV1;

public class HelloTraceTestV1 {

  @Test
  void begin_end() {
    HelloTraceV1 trace = new HelloTraceV1();
    TraceStatusV1 status = trace.begin("begin");
    trace.end(status);
  }

  @Test
  void begin_exception() {
    HelloTraceV1 trace = new HelloTraceV1();
    TraceStatusV1 status = trace.begin("hello");
    trace.exception(status, new IllegalStateException());
  }

}
