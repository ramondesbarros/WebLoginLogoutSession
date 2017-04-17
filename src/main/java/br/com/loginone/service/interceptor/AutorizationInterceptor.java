package br.com.loginone.service.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class AutorizationInterceptor extends HandlerInterceptorAdapter {
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        
        String uri = request.getRequestURI();
        if(uri.endsWith("login-form") || uri.endsWith("login") || uri.contains("resources")){
          return true;
        }
        
        if(request.getSession().getAttribute("usuarioLogado") != null) {
            return true;
          }
          response.sendRedirect("login-form");
          return false;
    }
}
