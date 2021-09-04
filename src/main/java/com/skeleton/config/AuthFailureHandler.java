package com.skeleton.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Slf4j
public class AuthFailureHandler extends SimpleUrlAuthenticationFailureHandler {
    static final String AUTH_EXCEPTION = "AUTH_EXCEPTION";

    @Override
    public void onAuthenticationFailure(HttpServletRequest request,
                                        HttpServletResponse response,
                                        AuthenticationException ex) throws IOException {
        final HttpSession httpSession = request.getSession();
        httpSession.setAttribute(AUTH_EXCEPTION, "login.error");

        log.info("AUTH EXCEPTION {}", ex.getMessage());

        getRedirectStrategy().sendRedirect(request, response, "/login?error");
    }
}