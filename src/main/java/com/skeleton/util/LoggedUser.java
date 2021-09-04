package com.skeleton.util;


import org.springframework.security.core.context.SecurityContextHolder;

public final class LoggedUser {

    public static boolean hasRole(final String role) {
        return SecurityContextHolder.getContext().getAuthentication().getAuthorities()
                .stream()
                .anyMatch(authority -> role.equals(authority.getAuthority()));
    }

    public static String getLoggedUserName() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}