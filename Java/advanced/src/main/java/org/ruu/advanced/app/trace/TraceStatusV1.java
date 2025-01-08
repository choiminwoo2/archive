package org.ruu.advanced.app.trace;

import lombok.Getter;

@Getter
public class TraceStatusV1 {
  private TraceIdV1 traceId;
  private Long startTimeMs;
  private String message;

  public TraceStatusV1(final TraceIdV1 traceId, final Long startTimeMs, final String message) {
    this.traceId = traceId;
    this.startTimeMs = startTimeMs;
    this.message = message;
  }
}
