package org.ruu.advanced.callback;

import org.ruu.advanced.app.trace.TraceStatusV1;
import org.ruu.advanced.logtrace.LogTrace;

public class TraceTemplate {

  private final LogTrace trace;

  public TraceTemplate(LogTrace trace) {
    this.trace = trace;
  }

  public <T> T execute(String message, TraceCallback<T> callback) {
    TraceStatusV1 status = null;
    try {
      status = trace.begin(message);
      T result = callback.call();
      trace.end(status);
      return result;
    } catch (Exception e) {
      trace.exception(status, e);
      throw e;
    }
  }
}
