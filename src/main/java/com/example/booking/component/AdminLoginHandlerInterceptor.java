package com.example.booking.component;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Administrator log in check
 */
public class AdminLoginHandlerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object admin = request.getSession().getAttribute("admin");
        if (admin == null) {
            // Administrator have not logged in, return to the admin-login page
            request.setAttribute("msg", "Please sign in first");
            request.getRequestDispatcher("/admin/login").forward(request, response);
            return false;
        } else {
            // Administrator have already logged in, let the request pass
            return true;
        }
    }
}
