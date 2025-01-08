package org.ruu.advanced.trace.v1.hellotrace;

import org.junit.jupiter.api.Test;
import org.ruu.advanced.app.trace.TraceStatusV1;
import org.ruu.advanced.app.trace.helloTrace.HelloTraceV1;
import org.ruu.advanced.app.trace.helloTrace.HelloTraceV2;

public class HelloTraceTestV2 {

  @Test
  void begin_end() {
    HelloTraceV2 trace = new HelloTraceV2();
    TraceStatusV1 status1 = trace.begin("begin");
    TraceStatusV1 status2 = trace.beginSync(status1.getTraceId(), "begin2");
    trace.end(status2);
    trace.end(status1);

  }

  @Test
  void begin_exception() {
    HelloTraceV2 trace = new HelloTraceV2();
    TraceStatusV1 status1 = trace.begin("begin");
    TraceStatusV1 status2 = trace.beginSync(status1.getTraceId(), "begin2");
    trace.exception(status2, new IllegalStateException());
    trace.exception(status1, new IllegalStateException());
  }

}
