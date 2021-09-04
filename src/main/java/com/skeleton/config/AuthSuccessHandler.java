package com.skeleton.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    public final Integer SESSION_TIMEOUT_IN_SECONDS = 3600;
    static final String AUTH_EXCEPTION = "AUTH_EXCEPTION";

    @Override
    public void onAuthenticationSuccess(final HttpServletRequest request,
                                        final HttpServletResponse response,
                                        final Authentication authentication)
            throws IOException, ServletException {
        final HttpSession httpSession = request.getSession();
        httpSession.removeAttribute(AUTH_EXCEPTION);
        httpSession.setMaxInactiveInterval(SESSION_TIMEOUT_IN_SECONDS);
        super.onAuthenticationSuccess(request, response, authentication);
    }
}
