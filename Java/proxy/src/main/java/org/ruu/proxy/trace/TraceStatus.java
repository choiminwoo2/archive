package org.ruu.proxy.trace;

import lombok.Getter;

@Getter
public class TraceStatus {
  private TraceId traceId;
  private Long startTimeMs;
  private String message;

  public TraceStatus(final TraceId traceId, final Long startTimeMs, final String message) {
    this.traceId = traceId;
    this.startTimeMs = startTimeMs;
    this.message = message;
  }
}
