package org.ruu.advanced.app.trace.helloTrace;


import lombok.extern.slf4j.Slf4j;
import org.ruu.advanced.app.trace.TraceIdV1;
import org.ruu.advanced.app.trace.TraceStatusV1;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class HelloTraceV1 {

  private static final String START_PREFIX = "-->";
  private static final String COMPLETE_PREFIX = "<--";
  private static final String EX_PREFIX = "<X-";


  public TraceStatusV1 begin(String message) {
    TraceIdV1 traceId = new TraceIdV1();
    Long startTimeMs = System.currentTimeMillis();
    log.info("[{}] {}{}", traceId.getId(), addSpace(START_PREFIX,
      traceId.getLevel()), message);
    return new TraceStatusV1(traceId, startTimeMs, message);
  }

  public void end(TraceStatusV1 status) {
    complete(status, null);
  }

  public void exception(TraceStatusV1 status, Exception e) {
    complete(status, e);
  }

  private void complete(TraceStatusV1 status, Exception e) {
    Long stopTimeMs = System.currentTimeMillis();
    long resultTimeMs = stopTimeMs - status.getStartTimeMs();
    TraceIdV1 traceId = status.getTraceId();
    if (e == null) {
      log.info("[{}] {}{} time={}ms", traceId.getId(),
        addSpace(COMPLETE_PREFIX, traceId.getLevel()), status.getMessage(),
        resultTimeMs);
    } else {
      log.info("[{}] {}{} time={}ms ex={}", traceId.getId(),
        addSpace(EX_PREFIX, traceId.getLevel()), status.getMessage(), resultTimeMs,
        e.toString());
    }
  }

  private static String addSpace(String prefix, int level) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < level; i++) {
      sb.append((i == level - 1) ? "|" + prefix : "|   ");
    }
    return sb.toString();
  }
}
