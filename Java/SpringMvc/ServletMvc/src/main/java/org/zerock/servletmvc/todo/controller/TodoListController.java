package org.zerock.servletmvc.todo.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;
import org.zerock.servletmvc.todo.dto.TodoDTO;
import org.zerock.servletmvc.todo.service.TodoService;

@WebServlet(name = "TodoListController", urlPatterns = "/todo/list")
@Log4j2
public class TodoListController extends HttpServlet {

  private TodoService todoService = TodoService.INSTANCE;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    log.info("[ Controller ]/todo/list");
    List<TodoDTO> list = null;
    try {
      list = todoService.getList();
    } catch (SQLException e) {
      log.info(e.getMessage());
      throw new RuntimeException(e);
    }

    req.setAttribute("list", list);

    req.getRequestDispatcher("/WEB-INF/todo/list.jsp")
        .forward(req, resp);
  }
}
