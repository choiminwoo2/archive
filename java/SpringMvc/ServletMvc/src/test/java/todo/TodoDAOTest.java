package todo;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.zerock.servletmvc.todo.dao.TodoDAO;
import org.zerock.servletmvc.todo.domain.TodoEntity;

public class TodoDAOTest {

  private TodoDAO todoDAO;


  @BeforeEach
  public void setUp() {
    todoDAO = new TodoDAO();
  }

  @Test
  void testTime() throws Exception {
    System.out.println(todoDAO.getTime());
  }

  @Test
  void getCount() throws Exception {
    int result = todoDAO.getCount();
    System.out.println("[todoList] count is " + result);
  }

  @Test
  void insert() throws Exception {
    TodoEntity todo =
        TodoEntity.builder()
            .title("Todo Sample Title")
            .dueDate(LocalDate.of(2021, 12, 31))
            .build();
    todoDAO.insert(todo);

  }

  @Test
  void getList() throws Exception {
    List<TodoEntity> list = todoDAO.selectAll();
    assertEquals(list.size(), todoDAO.getCount());

  }

  @Test
  void findByTitle() throws Exception {
    TodoEntity entity = todoDAO.findByTitle("getTitleTestData");

    assertEquals(entity.getTitle(), "getTitleTestData");
  }

  @Test
  void selectOne() throws Exception {

    TodoEntity entity = todoDAO.selectOne(3L);

    assertNotNull(entity);
    assertEquals(entity.getTno(), 3L);
  }

  @Test
  void updateOne() throws Exception {
    todoDAO.updateOne(
        TodoEntity.builder()
            .tno(3L)
            .title("Update Title")
            .dueDate(LocalDate.of(2022, 10, 15))
            .finished(true)
            .build()
    );
  }
}
