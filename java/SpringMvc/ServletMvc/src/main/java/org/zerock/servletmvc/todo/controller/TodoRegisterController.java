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
import javax.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j2;
import org.zerock.servletmvc.todo.dto.TodoDTO;
import org.zerock.servletmvc.todo.service.TodoService;

@WebServlet(name = "TodoRegisterController", urlPatterns = "/todo/register")
@Log4j2
public class TodoRegisterController extends HttpServlet {

  private TodoService todoService = TodoService.INSTANCE;
  private final DateTimeFormatter DATETIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    HttpSession httpSession = req.getSession();

    if (httpSession.getAttribute("loginInfo") == null) {
      log.info("쿠키는 있지만 로그인 정보가 없는 사용자");
      resp.sendRedirect("/login");
      return;
    }

    req.getRequestDispatcher("/WEB-INF/todo/register.jsp")
        .forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    log.info("[Controller] Todo를 등록했습니다");
    TodoDTO dto = TodoDTO.builder()
        .title(req.getParameter("title"))
        .dueDate(LocalDate.parse(req.getParameter("dueDate"), DATETIME_FORMATTER))
        .build();
    log.info(dto);
    try {
      todoService.register(dto);
    } catch (SQLException e) {
      log.info(e.getMessage());
      throw new RuntimeException(e);
    }
    resp.sendRedirect("/todo/list");
  }
}
