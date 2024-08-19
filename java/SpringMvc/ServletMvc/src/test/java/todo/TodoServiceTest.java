package todo;

import java.time.LocalDate;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.zerock.servletmvc.todo.dto.TodoDTO;
import org.zerock.servletmvc.todo.service.TodoService;

@Log4j2
public class TodoServiceTest {

  private TodoService todoService;

  @BeforeEach
  public void setUp() {
    todoService = TodoService.INSTANCE;
  }

  @Test
  void insert() throws Exception {
    TodoDTO dto = TodoDTO.builder()
        .title("JDBC Test Title")
        .dueDate(LocalDate.now())
        .build();
    log.info("--------------------------------");
    log.info(dto);
    todoService.register(dto);
  }

}
