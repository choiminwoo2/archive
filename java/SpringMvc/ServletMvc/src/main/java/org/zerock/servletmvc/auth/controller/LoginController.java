package org.zerock.servletmvc.auth.controller;

import java.io.IOException;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j2;
import org.zerock.servletmvc.auth.dto.MemberDTO;
import org.zerock.servletmvc.auth.service.MemberService;

@WebServlet(name = "LoginController", urlPatterns = "/login")
@Log4j2
public class LoginController extends HttpServlet {

    private MemberService memberService = MemberService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        log.info("login get.....");
        req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        log.info("login post........");

        String mid = req.getParameter("mid");
        String mpw = req.getParameter("mpw");
        String auto = req.getParameter("auto");
        boolean rememberId = auto != null && auto.equals("on");

        try {
            MemberDTO memberDTO = memberService.login(mid, mpw);
            if (rememberId) {
                String uuid = UUID.randomUUID().toString();

                memberService.updateUuid(mid, uuid);
                memberDTO.setUuid(uuid);

                Cookie cookie = new Cookie("remember-me", uuid);
                cookie.setMaxAge(60 * 60 * 24 * 7);
                cookie.setPath("/");

                resp.addCookie(cookie);
            }
            HttpSession session = req.getSession();
            session.setAttribute("loginInfo", memberDTO);
            resp.sendRedirect("/todo/list");
        } catch (Exception e) {
            log.info(e.getMessage());
            resp.sendRedirect("/login?result=error");
        }

    }
}
