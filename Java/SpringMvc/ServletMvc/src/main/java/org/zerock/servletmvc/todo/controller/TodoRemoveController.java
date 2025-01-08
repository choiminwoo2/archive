package org.zerock.servletmvc.todo.controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;
import org.zerock.servletmvc.todo.service.TodoService;

@WebServlet(name = "TodoRemoveController", urlPatterns = "/todo/remove")
@Log4j2
public class TodoRemoveController extends HttpServlet {

  private TodoService todoService = TodoService.INSTANCE;

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Long tno = Long.parseLong(req.getParameter("tno"));
    try {
      todoService.remove(tno);
    } catch (SQLException e) {
      log.info(e.getMessage());
      throw new RuntimeException(e);
    }
    resp.sendRedirect("/todo/list");
  }
}
