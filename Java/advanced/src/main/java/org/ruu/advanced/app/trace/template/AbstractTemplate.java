package org.ruu.advanced.app.trace.template;

import org.ruu.advanced.app.trace.TraceStatusV1;
import org.ruu.advanced.logtrace.LogTrace;

public abstract class AbstractTemplate<T> {

  private final LogTrace trace;

  public AbstractTemplate(LogTrace trace) {
    this.trace = trace;
  }

  public T execute(String message) {
    TraceStatusV1 status = null;
    try {
      status = trace.begin(message);
      T result = call();
      trace.end(status);
      return result;
    } catch (Exception e) {
      trace.exception(status, e);
      throw e;
    }
  }

  protected abstract T call();
}
