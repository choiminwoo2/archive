package org.zerock.servletmvc.auth.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j2;
import org.zerock.servletmvc.auth.dto.MemberDTO;
import org.zerock.servletmvc.auth.service.MemberService;

@WebFilter(filterName = "LoginCheckFilter", urlPatterns = {"/todo/*"})
@Log4j2
public class LoginCheckFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        log.info("Login check Filter");
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        HttpSession session = req.getSession();

        if (session.getAttribute("loginInfo") != null) {
            filterChain.doFilter(req, res);
            return;
        }

        Cookie cookie = findCookie(req.getCookies(), "remember-me");

        if (cookie == null) {
            res.sendRedirect("/login");
        }

        String uuid = cookie.getValue();
        try {
            MemberDTO memberDTO = MemberService.INSTANCE.findByUuid(uuid);
            if (memberDTO == null) {
                throw new Exception("쿠키가 유효하지 않음.");
            }
            session.setAttribute("loginInfo", memberDTO);
            filterChain.doFilter(req, res);
        } catch (Exception e) {
            e.printStackTrace();
            res.sendRedirect("/login");
        }

    }

    public Cookie findCookie(Cookie[] cookies, String name) {

        if (cookies == null || cookies.length == 0) {
            return null;
        }

        Optional<Cookie> result = Arrays.stream(cookies).filter(cookie -> cookie.getName().equals(name)).findFirst();
        return result.isPresent() ? result.get() : null;
    }
}
