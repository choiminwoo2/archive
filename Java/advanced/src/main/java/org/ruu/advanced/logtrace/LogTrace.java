package org.ruu.advanced.logtrace;

import org.ruu.advanced.app.trace.TraceStatusV1;

public interface LogTrace {

  TraceStatusV1 begin(String message);
  void end(TraceStatusV1 status);
  void exception(TraceStatusV1 status, Exception e);
}
