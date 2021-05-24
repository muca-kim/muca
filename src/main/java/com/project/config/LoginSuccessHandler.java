package com.project.config;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {
        String refer = request.getHeader("Referer");
        if (Objects.isNull(refer)) {
            response.sendRedirect("/");
        } else {
            Cookie cookie = new Cookie("isLogin", "1");
            response.addCookie(cookie);
            response.sendRedirect(refer);
        }
    }

}