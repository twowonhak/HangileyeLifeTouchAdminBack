package com.hangileye.lifetouch.aop;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Aspect     // AOP 사용
@Component  // Bean 으로 등록
@Slf4j
@RequiredArgsConstructor
public class LoginAspect {

    @Before("execution(* com.hangileye.lifetouch.controller..*(..))")
    public void startLog() {

            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            if (attributes != null) {
                HttpServletRequest request = attributes.getRequest();
                if(!request.getRequestURI().equals("/api/login/loginApi")){
                Cookie[] cookies = request.getCookies();
                    if (cookies != null) {
                        for (Cookie cookie : cookies) {
                            if ("ID".equals(cookie.getName())) {
                                String idValue = cookie.getValue();
                                return;
                            }
                        }
                    }
                    throw new RuntimeException("로그인 정보 없음");
                }
            }

    }
}
