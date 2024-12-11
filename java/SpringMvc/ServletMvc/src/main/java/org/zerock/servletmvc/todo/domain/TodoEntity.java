package org.zerock.servletmvc.todo.domain;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TodoEntity {

  private Long tno;
  private String title;
  private LocalDate dueDate;
  private boolean finished;
}
