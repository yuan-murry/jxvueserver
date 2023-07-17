package com.gxzh.jxvueserver.config;

import com.gxzh.jxvueserver.util.Token;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

@Component
public class TokenInterceptor implements HandlerInterceptor {
    private static final List<String> LOGIN_ENDPOINTS = Arrays.asList("/api/login/toLogin");
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String path = request.getRequestURI().substring(request.getContextPath().length()).replaceAll("[/]+$", "");
        if (LOGIN_ENDPOINTS.contains(path)) {

            return true;
        }
        String token = request.getHeader("Authorization");
        if (token == null || token.equals("")) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
            return false;
        }else{
            if(token.equals(Token.tokenvalue)){
                return true;
            }else{
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
                return false;
            }

        }



    }
}