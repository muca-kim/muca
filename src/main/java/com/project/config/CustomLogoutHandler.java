package com.project.config;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;

public class CustomLogoutHandler implements LogoutHandler {

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        String refer = request.getHeader("Referer");
        try {
            if (Objects.isNull(refer)) {
                response.sendRedirect("/");
            } else {
                Cookie cookie = new Cookie("isLogin", "0");
                response.addCookie(cookie);
                response.sendRedirect(refer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}