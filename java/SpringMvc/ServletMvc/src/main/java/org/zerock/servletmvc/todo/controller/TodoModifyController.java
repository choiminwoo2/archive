package org.zerock.servletmvc.todo.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;
import org.zerock.servletmvc.todo.dto.TodoDTO;
import org.zerock.servletmvc.todo.service.TodoService;

@WebServlet(name = "TodoModifyController", urlPatterns = "/todo/modify")
@Log4j2
public class TodoModifyController extends HttpServlet {

  private TodoService todoService = TodoService.INSTANCE;
  private final DateTimeFormatter DATETIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    log.info("modify!! get method");
    Long tno = Long.parseLong(req.getParameter("tno"));
    TodoDTO dto = null;
    try {
      dto = todoService.get(tno);
    } catch (SQLException e) {
      log.info(e.getMessage());
      throw new RuntimeException(e);
    }
    req.setAttribute("dto", dto);
    req.getRequestDispatcher("/WEB-INF/todo/modify.jsp")
        .forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    log.info("modifiy!! post method!!");
    Long tno = Long.parseLong(req.getParameter("tno"));
    String finishedStr = req.getParameter("finished");
    TodoDTO dto = TodoDTO.builder()
        .tno(tno)
        .title(req.getParameter("title"))
        .dueDate(LocalDate.parse(req.getParameter("dueDate"), DATETIME_FORMATTER))
        .finished(finishedStr != null && finishedStr.equals("on"))
        .build();
    try {
      todoService.modify(dto);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    resp.sendRedirect("/todo/list");
  }
}
