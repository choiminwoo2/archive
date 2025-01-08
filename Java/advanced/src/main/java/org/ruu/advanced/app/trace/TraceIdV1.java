package org.ruu.advanced.app.trace;

import java.util.UUID;
import lombok.Getter;

@Getter
public class TraceIdV1 {

  private String id;
  private int level;

  public TraceIdV1() {
    this.id = createId();
    this.level = 0;
  }

  private TraceIdV1(String id, int level) {
    this.id = id;
    this.level = level;
  }

  private String createId() {
    return UUID.randomUUID().toString().substring(0,8);
  }

  public TraceIdV1 createNextId() {
    return new TraceIdV1(id, level + 1);
  }

  public TraceIdV1 createPreviousId() {
    return new TraceIdV1(id, level - 1);
  }

  public boolean isFirstLevel() {
    return level == 0;
  }


}
