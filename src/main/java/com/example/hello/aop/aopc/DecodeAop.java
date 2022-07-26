package com.example.hello.aop.aopc;


import com.example.hello.aop.dto.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

@Aspect
@Component
public class DecodeAop {

    @Pointcut("execution(* com.example.hello.aop.controller..*.*(..))")
    private void cut(){}

    @Pointcut("@annotation(com.example.hello.annotation.Decode)")
    private void enableDecode(){}


    @Before("cut() && enableDecode()")
    public void before(JoinPoint joinPoint) throws UnsupportedEncodingException {
        Object[] args = joinPoint.getArgs();

        for(Object arg : args){
            if(arg instanceof User){
                User user = User.class.cast(arg);
                String base64Email = user.getEmail();
                String email = new String(Base64.getDecoder().decode(base64Email), "UTF-8");
                user.setEmail(email);
            }
        }
    }
    @AfterReturning(value = "cut() && enableDecode()", returning = "returnObj")
    public void afterReturn(JoinPoint joinPoint, Object returnObj) {
        if(returnObj instanceof  User){
            User user = User.class.cast(returnObj);
            String email = user.getEmail();
            String bas64Email = Base64.getEncoder().encodeToString(email.getBytes());
            user.setEmail(bas64Email);


        }
    }


}
