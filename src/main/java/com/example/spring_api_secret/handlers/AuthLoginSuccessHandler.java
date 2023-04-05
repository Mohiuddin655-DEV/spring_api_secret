package com.example.spring_api_secret.handlers;

import com.example.spring_api_secret.entity.AuthUser;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import java.io.IOException;

public class AuthLoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        AuthUser user = (AuthUser) authentication.getPrincipal();
        String email = user.getEmail();
        System.out.println("Customer's email: " + email);
    }
}
