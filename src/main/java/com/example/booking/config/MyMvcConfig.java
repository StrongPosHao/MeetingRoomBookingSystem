package com.example.booking.config;

import com.example.booking.component.AdminLoginHandlerInterceptor;
import com.example.booking.component.UserLoginHandlerInterceptor;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    public WebServerFactoryCustomizer webServerFactoryCustomizer() {
        return new WebServerFactoryCustomizer<ConfigurableWebServerFactory>() {
            @Override
            public void customize(ConfigurableWebServerFactory factory) {
                factory.setPort(8083);
            }
        };

    }

    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/login.html").setViewName("login");
                registry.addViewController("/index.html").setViewName("index");
//                registry.addViewController("/admin-login.html").setViewName("admin/login");
            }

            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                // register user login handler interceptor
                registry.addInterceptor(new UserLoginHandlerInterceptor()).addPathPatterns("/**")
                        .excludePathPatterns("/login.html", "/", "/user/login", "/user/register", "/meeting/**",
                                "/admin-login.html", "/room/**", "/rooms", "/admin/**", "/users", "/admin/users",
                                "/webjars/**", "/css/**", "/image/*", "/js/**");
                registry.addInterceptor(new AdminLoginHandlerInterceptor()).addPathPatterns("/**")
                        .excludePathPatterns("/login.html", "/", "/user/*", "/user", "/meeting/*", "/meeting",
                                "/admin-login.html", "/admin/login", "/index", "/rooms",
                                "/webjars/**", "/css/**", "/image/*", "/js/**");
            }
        };
    }

}
